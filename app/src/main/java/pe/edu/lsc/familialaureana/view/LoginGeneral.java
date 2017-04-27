package pe.edu.lsc.familialaureana.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.lsc.familialaureana.view.Padre.PaginaPrincipalDocet;
import pe.edu.lsc.familialaureana.R;

import static android.Manifest.permission.READ_CONTACTS;

public class LoginGeneral extends AppCompatActivity implements View.OnClickListener{


    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;
    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };

    // declaracion de varibles globales
    Button iniciar;
    TextView txtRecuperarCont,txtRegistrar;
    ImageView btnGoogle,btnFace,btnEdmodo;

    // UI references.
    private UserLoginTask mAuthTask = null;
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_general);

        //instanciaciond evaribles globales
        iniciar = (Button) findViewById(R.id.email_sign_in_button);
        iniciar.setOnClickListener(this);
        btnGoogle = (ImageView) findViewById(R.id.imageGoogle);
        btnGoogle.setOnClickListener(this);
        btnFace = (ImageView) findViewById(R.id.imageFace);
        btnFace.setOnClickListener(this);
        btnEdmodo = (ImageView) findViewById(R.id.imageEdmodo);
        btnEdmodo.setOnClickListener(this);
        txtRegistrar=(TextView) findViewById(R.id.textRegistrase);
        txtRegistrar.setOnClickListener(this);
        txtRecuperarCont=(TextView) findViewById(R.id.textRecuperarContrasena);
        txtRecuperarCont.setOnClickListener(this);

        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        populateAutoComplete();

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

    }
    //                  MOSTRAR SUGERENCIAS CUANDO EL USUARIO ESCRIBE UN EMAIL
    private void populateAutoComplete() {
        /**Comprobamos si los permisos fueron concedidos. */
        if (!mayRequestContacts()) return;

        /**Preparar el cargador o bien conectar con uno ya exixtente.
         * Carga una consulta asincrona para buscar el o los emails almacenados en el perfil de usuario */

        //getLoaderManager().initLoader(0, null, this);
    }

    //           SOLICITAR EL PERMISO PARA LEER LOS CONTACTOS DEL USUARIO
    private boolean mayRequestContacts() {
        /**Analiza si la versión de SDK del dispositivo sobre el cual esta corriendo
         la aplicación es menor a la versión Mashmallow */
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        /**Comprueba si el permiso para leer contactos se ha concedido con anterioridad */
        if (checkSelfPermission(READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        /**Si un usuario previamente a denegado el permiso y aun asi sigue intentando entrar en la
         funcionalidad, por lo que es conveniete informarle las razones del permiso. */
        if (shouldShowRequestPermissionRationale(READ_CONTACTS)) {
            /**Generar una notificación para informarle al usuario el porque de la solicitud del
             permiso, acompañado de un boton para conceder los permisos a la aplicación. */
            Snackbar.make(mEmailView, R.string.permission_rationale, Snackbar.LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok, new View.OnClickListener() {
                        @Override
                        @TargetApi(Build.VERSION_CODES.M)
                        public void onClick(View v) {
                            /**Solicita que se le otorguen permisos a esta aplicación solo hizo
                             click sobre el boton OK del Snackbar. */
                            requestPermissions(new String[]{READ_CONTACTS}, REQUEST_READ_CONTACTS);
                        }
                    });
        } else {
            requestPermissions(new String[]{READ_CONTACTS}, REQUEST_READ_CONTACTS);
        }
        return false;
    }

    //                  VALIDAR LOS COMPONENTES DEL FORMULARIO DE INGRESO
    private void attemptLogin() {
        /**Comprobar si el objeto para el usuario esta vacio o no*/
        if (mAuthTask != null) {
            return;
        }

        /**Resetea los Errores*/
        mEmailView.setError(null);
        mPasswordView.setError(null);

        /**Obtiene y guarda los valores respectivos para el email y el password*/
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        /**
         * Bandera evidenciar algun error durante la validación de los datos
         * Variable para contener el campo a ser enfocado
         */
        boolean cancel = false;
        View focusView = null;

        /**Comprobar si el password ingresado no es nulo y es valido*/
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            /**Envia el error a la caja de Texto*/
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        /**Comprobar si el campo para el Email esta vacio. */
        if (TextUtils.isEmpty(email)) {
            /**Envia el error a la caja de Texto*/
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        }
        /**Comprobar si el Email Ingresado es valido. */
        else if (!isEmailValid(email)) {
            /**Envia el error a la caja de Texto*/
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        /**Comprobar si hubo un fallo durante el ingreso de datos*/
        if (cancel) {
            /**Enfocar el Campo del Error*/
            focusView.requestFocus();
        } else {
            /**Cargar Animación con una barra de progreso*/
            showProgress(true);
            /**Crea un nuevo Usuario a partir de la clase  mAuthTask*/
            mAuthTask = new UserLoginTask(email, password);
            /**Lanzar el Hilo para la Autenticación del Usuario*/
            mAuthTask.execute((Void) null);
            Intent i = new Intent(this, PaginaPrincipalDocet.class);
            startActivity(i);
        }
    }
    //Comprobar si un email es valido o no
    private boolean isEmailValid(String email) {
        /**Si la cadena contiene el caracter @ es un email valido*/
        return email.contains("@");
    }
    //Comprobar si la contraseña ingresada cumple con restricciones establecidas
    private boolean isPasswordValid(String password) {
        /**Si la cadena supera los 4 caracteres es una contraseña valida*/
        return password.length() > 4;
    }

    //                  CARGAR ANIMACION DE UNA BARRA DE PROGRESO CIRCULAR
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    // funcion que controla la accion a tomar al precionar sobre un elemento de la actividad
    public void onClick(View v) {
        // declaracion de vavribles locales
        Intent i;
        Uri uri;
        Intent in;
        switch (v.getId()) {
            case R.id.email_sign_in_button:
                attemptLogin();

                break;

            case R.id.imageGoogle:
                uri = Uri.parse("https://jarroba.com/como-solucionar-errores-en-android/");
                in = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(in);
                break;
            case R.id.imageFace:
                uri = Uri.parse("https://www.facebook.com/lsc.edu.pe/");
                in = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(in);
                break;
            case R.id.imageEdmodo:
                uri = Uri.parse("https://www.edmodo.com/");
                in = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(in);
                break;
            case R.id.textRegistrase:
                i = new Intent(this, RegistroG.class);
                startActivity(i);
                break;
            case R.id.textRecuperarContrasena:
                i = new Intent(this, RecuperarContrasenia.class);
                startActivity(i);
                break;
            default:
                break;
        }

    }

    //  CLASE PARA ALMACENAR LOS USUARIOS Y METODOS ASICRONOS PARA VALIDAR EL USUARIO INGRESADO
    //==============================================================================================
    //----------------------------------------------------------------------------------------------
    //Clase para Almacenar los Usuarios
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        //Hilo para validar si el Correo y contraseña ingresados son correctos
        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                /**Ejecución del Hilo con un retraso de 2 segundos*/
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            /**Ciclo en el cual se comparan los Emails y Contraseñas alamacenados en el Array tipo
             * string definido al inicio del activity y el email y clave ingresados por el usuario
             * en el formulario de Login*/
            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {
                    /**Retorna verdadero si  la Contraseña Coincide*/
                    return pieces[1].equals(mPassword);
                }
            }

            // TODO: register the new account here.
            return true;
        }

        //Muestra en el Activity actual el resultado de la tarea que se ejecuto en el Hilo

        /**
         * En este caso Abre el Activity Bienvenido si los datos Fueron correctos de lo contrario
         * Lanza un mensaje Evidenciando el problema
         */

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            showProgress(false);

            if (success) {
                finish();
            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }
        }

        //En caso de que se cancele la Tarea inmersa en el Hilo
        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }
}
