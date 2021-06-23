package com.skypan.wbse.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.skypan.wbse.NewArticleActivity;
import com.skypan.wbse.R;
import com.skypan.wbse.retrofit.Ack;
import com.skypan.wbse.retrofit.Comment;
import com.skypan.wbse.retrofit.CommentRequest;
import com.skypan.wbse.retrofit.RetrofitManager;
import com.skypan.wbse.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class cardAdapter extends RecyclerView.Adapter<cardAdapter.viewHolder> {
    private Context mContext;

    public cardAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public cardAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new cardAdapter.viewHolder(LayoutInflater.from(mContext).inflate(R.layout.acticle_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull cardAdapter.viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class viewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private Button comment,delete,edit;
        private ImageView favorite;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.article_id);
            comment = itemView.findViewById(R.id.article_comment);
            favorite = itemView.findViewById(R.id.article_favorite);
            delete = itemView.findViewById(R.id.article_delete);
            edit = itemView.findViewById(R.id.article_edit);

            favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //todo:
//                    RetrofitService retrofitService = RetrofitManager.getInstance().getService();
//                    Call<Ack> call = retrofitService.newFavorite("","");
//                    call.enqueue(new Callback<Ack>() {
//                        @Override
//                        public void onResponse(Call<Ack> call, Response<Ack> response) {
//
//                        }
//
//                        @Override
//                        public void onFailure(Call<Ack> call, Throwable t) {
//
//                        }
//                    });
                }
            });


            comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
                    View content_layout = LayoutInflater.from(mContext).inflate(R.layout.comment, null);

                    RecyclerView rv_comment = content_layout.findViewById(R.id.rv_comment);
                    EditText c_edit = content_layout.findViewById(R.id.new_comment);

                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    rv_comment.setLayoutManager(new LinearLayoutManager(mContext));
                    rv_comment.setAdapter(new commentAdapter(mContext));

                    alertDialog.setPositiveButton("Send Comment", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //todo:
//                            CommentRequest c =null;
//                            c.setCommentContent(c_edit.getText().toString());
//                            c.setReviewrId("");
//                            RetrofitService retrofitService = RetrofitManager.getInstance().getService();
//                            Call<Ack> call = retrofitService.newComment(c,"");
//                            call.enqueue(new Callback<Ack>() {
//                                @Override
//                                public void onResponse(Call<Ack> call, Response<Ack> response) {
//
//                                }
//
//                                @Override
//                                public void onFailure(Call<Ack> call, Throwable t) {
//
//                                }
//                            });
                        }
                    });
                    alertDialog.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    alertDialog.setView(content_layout);
                    alertDialog.show();
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //todo:
//                    RetrofitService retrofitService = RetrofitManager.getInstance().getService();
//                    Call<Ack> call = retrofitService.deleteEvent("");
//                    call.enqueue(new Callback<Ack>() {
//                        @Override
//                        public void onResponse(Call<Ack> call, Response<Ack> response) {
//
//                        }
//
//                        @Override
//                        public void onFailure(Call<Ack> call, Throwable t) {
//
//                        }
//                    });
                }
            });

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(new Intent(mContext, NewArticleActivity.class));
                }
            });

        }
    }
}
