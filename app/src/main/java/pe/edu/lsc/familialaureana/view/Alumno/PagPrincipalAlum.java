package pe.edu.lsc.familialaureana.view.Alumno;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import pe.edu.lsc.familialaureana.R;
import pe.edu.lsc.familialaureana.view.Buscar;
import pe.edu.lsc.familialaureana.view.CuentaUsuario;
import pe.edu.lsc.familialaureana.view.NuevaConversacion;
import pe.edu.lsc.familialaureana.view.NuevaPublicacion;
import pe.edu.lsc.familialaureana.view.Padre.AsistenciaPadre;
import pe.edu.lsc.familialaureana.view.Padre.CalificaionesPadre;
import pe.edu.lsc.familialaureana.view.Padre.FragmentHome;
import pe.edu.lsc.familialaureana.view.Padre.InsigniasPadre;
import pe.edu.lsc.familialaureana.view.Padre.Notificaiones;
import pe.edu.lsc.familialaureana.view.Padre.PaginaPrincipalDocet;
import pe.edu.lsc.familialaureana.view.Padre.PruevaHorario;
import pe.edu.lsc.familialaureana.view.Padre.chat;

public class PagPrincipalAlum extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , FragmentHome.OnFragmentInteractionListener{


    // declaracion de variable globales
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    boolean click = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pag_principal_alum);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);

        mViewPager.setAdapter(mSectionsPagerAdapter);

        //  signando cada fragmento al tab correspondiente
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.accoun);
        tabLayout.getTabAt(2).setIcon(R.drawable.earth);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    // funcion que hace el llamado a la activity nuevaConversacion
    public void irSaludo (View view){
        Intent i=new Intent(this, NuevaConversacion.class);
        startActivity(i);
    }

    // funcion que hace el llamado a la activity nuevapublicacion
    public void NuevaPublicaion (View view){
        Intent i=new Intent(this, NuevaPublicacion.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pag_principal_alum, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.buscar){
            Intent i= new Intent(this, Buscar.class);
            startActivity(i);

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Boolean francmenTransacciton = false;
        Fragment fragment= null;
        Intent i;

        if (id == R.id.publicaciones) {

        } else if (id == R.id.horarios) {
            i=new Intent(this, PruevaHorario.class);
            startActivity(i);

        } else if (id == R.id.insignias) {
            i=new Intent(this, InsigniasPadre.class);
            startActivity(i);

        } else if (id == R.id.calificaciones) {
            i=new Intent(this, CalificacionesAlumno.class);
            startActivity(i);

        } else if (id == R.id.assitencias) {
            i=new Intent(this,AsistenciaPadre.class);
            startActivity(i);
        } else if (id == R.id.nav_configuraciones) {

        }else if(id == R.id.nav_share){
            i=new Intent(this, CuentaUsuario.class);
            startActivity(i);
        }
        if(francmenTransacciton) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_pagina_principal,fragment)
                    .commit();
            item.setCheckable(true);
            getSupportActionBar().setTitle(item.getTitle());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {

            super(fm);
        }

        @Override
        // funcion que controla que fragmento mostrar al presionar sobre un tab
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    FragmentHome home=new FragmentHome();
                    return home;

                case 1:
                    chat cat=new chat();
                    return cat;

                case 2:
                    Notificaiones not=new Notificaiones();
                    return not;

                default:
                    return null;
            }
        }

        @Override
        // funcion que define la cantidad de tab
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
}
