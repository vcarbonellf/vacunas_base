package org.example.vacunas;

import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import static org.example.vacunas.VacunasFirestore.VACUNAS;
import static org.example.vacunas.VacunasFirestore.crearVacunas;

public class MainActivity extends AppCompatActivity {
    private AdaptadorVacunas adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        crearVacunas();
        Query query = FirebaseFirestore.getInstance()
                .collection(VACUNAS)
                .limit(50);
        FirestoreRecyclerOptions<Vacuna> opciones = new FirestoreRecyclerOptions
                .Builder<Vacuna>().setQuery(query, Vacuna.class).build();
        adaptador = new AdaptadorVacunas(opciones);
        final RecyclerView recyclerView = findViewById(R.id.reciclerViewVacunas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptador);
    }

    @Override public void onStart() {
        super.onStart();
        adaptador.startListening();
    }
    @Override public void onStop() {
        super.onStop();
        adaptador.stopListening();
    }
}
