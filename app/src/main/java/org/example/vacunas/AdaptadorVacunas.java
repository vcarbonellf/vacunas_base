package org.example.vacunas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.io.InputStream;

public class AdaptadorVacunas extends FirestoreRecyclerAdapter
        <Vacuna, AdaptadorVacunas.ViewHolder> {
    protected View.OnClickListener onClickListener;

    public AdaptadorVacunas(@NonNull FirestoreRecyclerOptions<Vacuna>
                                    options) {
        super(options);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vacuna, parent, false);
        view.setOnClickListener(onClickListener);
        return new ViewHolder(view);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtVacuna, txtEmpresa, txtUbicacion, txtEstado;
        public ImageView imagen;
        public ViewHolder(View itemView) {
            super(itemView);
            txtVacuna = (TextView) itemView.findViewById(R.id.txtVacuna);
            txtEmpresa = (TextView) itemView.findViewById(R.id.txtEmpresa);
            txtUbicacion = (TextView)
                    itemView.findViewById(R.id.txtUbicacion);
            txtEstado = (TextView) itemView.findViewById(R.id.txtEstado);
            imagen = (ImageView) itemView.findViewById(R.id.imgImagen);
        }
    }

    @Override protected void onBindViewHolder(@NonNull ViewHolder holder,
                                              int position, @NonNull Vacuna item) {
        holder.txtVacuna.setText(item.getVacuna());
        holder.txtEmpresa.setText(item.getEmpresa());
        holder.txtUbicacion.setText(item.getUbicacion());
        holder.txtEstado.setText(item.getEstado());
        new DownloadImageTask((ImageView) holder.imagen)
                .execute(item.getImagen());
        holder.itemView.setOnClickListener(onClickListener);
    }

    public void setOnItemClickListener(View.OnClickListener onClick) {
        onClickListener = onClick;
    }

    private class DownloadImageTask extends AsyncTask<String,Void,Bitmap> {
        ImageView imageView;

        public DownloadImageTask(ImageView bmImage) {
            this.imageView = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mImagen = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mImagen = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return mImagen;
        }

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }
}

