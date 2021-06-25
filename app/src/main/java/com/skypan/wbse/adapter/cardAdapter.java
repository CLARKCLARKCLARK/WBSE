package com.skypan.wbse.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.skypan.wbse.EditArticleActivity;
import com.skypan.wbse.FavoriteFragment;
import com.skypan.wbse.MainActivity;
import com.skypan.wbse.NewArticleActivity;
import com.skypan.wbse.R;
import com.skypan.wbse.retrofit.Ack;
import com.skypan.wbse.retrofit.Article;
import com.skypan.wbse.retrofit.FavRequest;
import com.skypan.wbse.retrofit.RetrofitManager;
import com.skypan.wbse.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class cardAdapter extends RecyclerView.Adapter<cardAdapter.viewHolder> {
    private Context mContext;
    private  List<Article> article;
    public cardAdapter(Context mContext, List<Article> article) {
        this.mContext = mContext;
        this.article = article;
    }

    @NonNull
    @Override
    public cardAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new cardAdapter.viewHolder(LayoutInflater.from(mContext).inflate(R.layout.acticle_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull cardAdapter.viewHolder holder, int position) {

        SharedPreferences sharedPreferences = mContext.getSharedPreferences("userId" , MODE_PRIVATE);
        String id = sharedPreferences.getString("Id" ,"");
        System.out.println(article.get(position).getAuthorId() + "555" + id);
        if(!article.get(position).getAuthorId().equals(id)){
            holder.edit.setVisibility(View.GONE);
            holder.delete.setVisibility(View.GONE);
        }
        holder.title.setText(article.get(position).getArticleName());
        holder.author.setText(article.get(position).getAuthorId());
        holder.date.setText(article.get(position).getPostTime());
        holder.content.setText(article.get(position).getArticleContent().toString());

    }

    @Override
    public int getItemCount() {
        return article.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private Button comment,delete,edit,favorite;

        private TextView title,author,date,content;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            comment = itemView.findViewById(R.id.article_comment);
            favorite = itemView.findViewById(R.id.article_favorite);
            delete = itemView.findViewById(R.id.article_delete);
            edit = itemView.findViewById(R.id.article_edit);
            title = itemView.findViewById(R.id.article_title);
            author = itemView.findViewById(R.id.author_id);
            date = itemView.findViewById(R.id.article_date);
            content = itemView.findViewById(R.id.article);

            favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                    public void onClick(View v) {
                    final int position = getAdapterPosition();
                    SharedPreferences sharedPreferences = mContext.getSharedPreferences("userId" , MODE_PRIVATE);
                    String id = sharedPreferences.getString("Id" ,"");
                    if (id==""){
                        Toast.makeText(mContext, "login PLZ", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        FavRequest favRequest = new FavRequest();
                        favRequest.setArticleId(article.get(position).getArticleId());
                        favRequest.setUserId(id);
                        System.out.println(article.get(position).getArticleId() + "32323" + id);
                        RetrofitService retrofitService = RetrofitManager.getInstance().getService();
                        Call<Ack> call = retrofitService.newFavorite(favRequest);
                        call.enqueue(new Callback<Ack>() {
                            @Override
                            public void onResponse(Call<Ack> call, Response<Ack> response) {
                                if (!response.isSuccessful()) {
                                    Toast.makeText(mContext, "伺服器錯誤，請稍後再試", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(mContext, "favorite success", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Ack> call, Throwable t) {

                            }
                        });
                    }
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

                    alertDialog.setPositiveButton("Send articleComment", new DialogInterface.OnClickListener() {
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

                        final int position = getAdapterPosition();
                        System.out.println("123"+position);
                        RetrofitService retrofitService = RetrofitManager.getInstance().getService();
                        Call<Ack> call = retrofitService.deleteEvent(article.get(position).getArticleId());
                        call.enqueue(new Callback<Ack>() {
                            @Override
                            public void onResponse(Call<Ack> call, Response<Ack> response) {
                                if(!response.isSuccessful()){
                                    Toast.makeText(mContext, "伺服器錯誤，請稍後再試", Toast.LENGTH_SHORT).show();
                                }
                                Toast.makeText(mContext, "success", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(mContext, MainActivity.class);
                                mContext.startActivity(intent);

                            }

                            @Override
                            public void onFailure(Call<Ack> call, Throwable t) {

                            }
                        });
                    }
                });

                edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        final int position = getAdapterPosition();
                        Intent intent = new Intent(mContext, EditArticleActivity.class);
                        intent.putExtra("ArticleId", article.get(position).getArticleId());
                        mContext.startActivity(intent);

                    }
                });

        }
    }
}
