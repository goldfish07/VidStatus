package com.github.goldfish07.vidstatus.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.goldfish07.vidstatus.R;
import com.github.goldfish07.vidstatus.model.Msg;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.List;

public class VidAdapter extends RecyclerView.Adapter<VidAdapter.ViewHolder> {

    Context context;
    public List<Msg> vid;
    public ViewHolder holder;
    RecyclerView recyclerView;
    int position;

    public VidAdapter(Context context, List<Msg> vid) {
        this.context = context;
        this.vid = vid;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        recyclerView = (RecyclerView) parent;
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_vid, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        this.holder = holder;
        this.position = position;
        //  recyclerView.addOnScrollListener(scrollListener);
        String fullName = vid.get(position).getUserInfo().getFirst_name() + " "
                + vid.get(position).getUserInfo().getLast_name();
        holder.creator_name.setText(vid.get(position).getUserInfo().getUsername());
        holder.creator_description.setText(vid.get(position).getDescription());
        holder.txt_like.setText(String.valueOf(vid.get(position).getCount().getLike_count()));
        holder.txt_comment.setText(String.valueOf(vid.get(position).getCount().getVideo_comment_count()));
        this.holder.progressBar.setVisibility(View.VISIBLE);
        Log.e("recycler onBind", String.valueOf(position));
    }

    @Override
    public void onViewAttachedToWindow(@NonNull ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
            ViewHolder preHolder = (ViewHolder) recyclerView.findViewHolderForAdapterPosition(position - 1);
            if (preHolder != null && preHolder.exoPlayer.isPlaying()) {
                preHolder.exoPlayer.stop();
                preHolder.progressBar.setVisibility(View.GONE);
            }
            holder.playVideo(position);
         holder.progressBar.setVisibility(View.VISIBLE);

    }

//    RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener() {
//        @Override
//        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//            super.onScrolled(recyclerView, dx, dy);
//            Log.e("OnScroll-Recycler DX", String.valueOf(dx));
//            Log.e("OnScroll-Recycler DY", String.valueOf(dy));
//            ViewHolder preHolder = (ViewHolder) recyclerView.findViewHolderForAdapterPosition(position - 1);
//            if (preHolder != null && preHolder.exoPlayer.isPlaying()) {
//                preHolder.exoPlayer.stop();
//            }
//            holder.playVideo(position);
//        }
//    };


    @Override
    public void onViewDetachedFromWindow(@NonNull ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.pauseVideo();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void update(List<Msg> msg, int position) {
        vid = msg;
        notifyDataSetChanged();
    }


//    void stopVideo(){
//        if(exoPlayer !=null && exoPlayer.isPlaying()){
//            exoPlayer.stop();
//            exoPlayer = null;
//            holder.playerView.setPlayer(null);
//        }
//    }

    @Override
    public int getItemCount() {
        return vid.size();
    }

    public void onPause() {
        if (holder.exoPlayer != null)
            holder.pauseVideo(holder);
    }

    public void onResume() {
        if (holder.exoPlayer != null)
            holder.resumeVideo();
    }

    public void onStop() {
        if (holder.exoPlayer.isPlaying()) {
            holder.stopVideo();
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView creator_name;
        private final TextView creator_description;
        private final TextView txt_like;
        private final TextView txt_comment;
        private final TextView txt_share;

        private final PlayerView playerView;
        private final ProgressBar progressBar;
        private ExoPlayer exoPlayer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setTag(itemView);
            setIsRecyclable(false);
            creator_name = itemView.findViewById(R.id.creator_username);
            creator_description = itemView.findViewById(R.id.creator_description);
            txt_like = itemView.findViewById(R.id.txtFav);
            txt_comment = itemView.findViewById(R.id.txtComment);
            txt_share = itemView.findViewById(R.id.txtShare);
            playerView = itemView.findViewById(R.id.playerView);
            progressBar = itemView.findViewById(R.id.progressBar);
            itemView.setTag(this);
        }

        void playVideo(int position) {
            exoPlayer = new ExoPlayer.Builder(context).build();
            exoPlayer.setPlayWhenReady(false);
            playerView.setPlayer(exoPlayer);
            if (vid.get(position) != null) {
                MediaItem mediaItem = MediaItem.fromUri(vid.get(position).getVideo());
                exoPlayer.addMediaItem(mediaItem);
                exoPlayer.addListener(new Player.Listener() {
                    @Override
                    public void onPlaybackStateChanged(int playbackState) {
                        Player.Listener.super.onPlaybackStateChanged(playbackState);
                        if (playbackState == Player.STATE_READY) {
                            exoPlayer.play();
                            holder.progressBar.setVisibility(View.GONE);
                        } else if(playbackState == Player.STATE_ENDED){
                            recyclerView.smoothScrollToPosition(position + 1);
                            pauseVideo();
                        }
                    }
                });
                exoPlayer.prepare();
            }
        }

        public void pauseVideo(ViewHolder holder) {
            if (exoPlayer.getPlaybackState() == Player.STATE_BUFFERING) {
                holder.exoPlayer.pause();
                holder.progressBar.setVisibility(View.VISIBLE);
            }
        }

        public void pauseVideo() {
            if (exoPlayer.getPlaybackState() == Player.STATE_BUFFERING) {
                exoPlayer.pause();
                holder.progressBar.setVisibility(View.VISIBLE);
            }
        }

        boolean isPlaying() {
            if (exoPlayer != null)
                return exoPlayer.isPlaying();
            return false;
        }

        public void resumeVideo() {
            if (exoPlayer.getPlaybackState() == Player.STATE_IDLE) {
                exoPlayer.play();
                holder.progressBar.setVisibility(View.GONE);
            }
        }

        public void stopVideo() {
            if (exoPlayer.getPlaybackState() == Player.STATE_IDLE ||
                    exoPlayer.getPlaybackState() == Player.STATE_READY ||
                    exoPlayer.getPlaybackState() == Player.STATE_ENDED ||
                    exoPlayer.getPlaybackState() == Player.STATE_BUFFERING) {
                exoPlayer.stop();
                exoPlayer.release();
            }
        }
    }
}
