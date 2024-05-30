package com.usta.laboratoriovirtual.classProgramming.weeksPOO

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.usta.laboratoriovirtual.R
import com.usta.laboratoriovirtual.databinding.ActivityTheLastOneBinding
import androidx.appcompat.app.AlertDialog
import com.usta.laboratoriovirtual.classProgramming.PooClassScreen


class TheLastOneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTheLastOneBinding

    private var listaLibros = mutableListOf<Libro>()

    private lateinit var descripcionAgregar: TextView
    private lateinit var tituloEditText: EditText
    private lateinit var autorEditText: EditText
    private lateinit var añoEditText: EditText
    private lateinit var btnAgregar: Button

    private lateinit var btnPrestar: Button
    private lateinit var descPrestar: TextView
    private lateinit var tituloPrestar : EditText

    private lateinit var btnDevolver: Button
    private lateinit var descDevolver : TextView
    private lateinit var tituloDevolver: EditText

    private lateinit var btnMostrar: Button
    private lateinit var descMostrar: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTheLastOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val btnBack = findViewById<ImageButton>(R.id.back_button_main)

        btnBack.setOnClickListener{
            val intent = Intent(this, PooClassScreen::class.java)
            startActivity(intent)
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.updatePadding(
                top = systemInsets.top,
                bottom = systemInsets.bottom
            )
            WindowInsetsCompat.CONSUMED
        }

        //Agregar Libro

        tituloEditText = findViewById(R.id.tituloEditText)
        autorEditText = findViewById(R.id.autorEditText)
        añoEditText = findViewById(R.id.descEditText)
        btnAgregar = findViewById(R.id.btnAgregar)
        descripcionAgregar = findViewById(R.id.agregarNuevoLibro)



        btnAgregar.setOnClickListener{
            val titulo = tituloEditText.text.toString()
            val autor = autorEditText.text.toString()
            val desc = añoEditText.text.toString()

            if (titulo.isNotEmpty() && autor.isNotEmpty() && desc.isNotEmpty()){
                val nuevoLibro  = Libro(titulo, autor, desc)
                listaLibros.add(nuevoLibro)
                mostrarDialogoLibroAgregado(nuevoLibro)

                mostrarMensajeEncapsulamiento(descripcionAgregar)
            }else{
                mostrarDialogoError("Por favor, complete todos los campos correctamente antes de agregar el libro.")
            }

        }

        //Prestar Libro

        descPrestar = findViewById(R.id.descripcionPrestar)
        tituloPrestar = findViewById(R.id.tituloPrestarEditText)
        btnPrestar = findViewById(R.id.btnPrestar)
        btnPrestar.setOnClickListener{
            val titulo = tituloPrestar.text.toString()
            if (titulo.isNotEmpty()){
                try{
                    prestarLibro(titulo)
                    mostrarMensajeGestionErrores(descPrestar)
                } catch (e: Exception) {
                    mostrarDialogoError(e.message ?: "Error desconocido")
                }
            } else {
                mostrarDialogoError("Por favor, ingrese el título del libro que desea llevar.")
            }
        }

        //Devolver Libro

        descDevolver = findViewById(R.id.descripcionDevolver)
        tituloDevolver = findViewById(R.id.tituloDevolverEditText)
        btnDevolver = findViewById(R.id.btnDevolver)
        btnDevolver.setOnClickListener{
            val titulo = tituloDevolver.text.toString()
            if (titulo.isNotEmpty()){
                try{
                    devolverLibro(titulo)
                    mostrarMensajeDevolver(descDevolver)
                } catch (e: Exception) {
                    mostrarDialogoError(e.message ?: "Error desconocido")
                }
            } else {
                mostrarDialogoError("Por favor, ingrese el título del libro que desea devolver.")
            }
        }

        //Mostrar Libros

        btnMostrar = findViewById(R.id.btnMostrar)
        descMostrar = findViewById(R.id.descripcionMostrar)

        btnMostrar.setOnClickListener {
            mostrarListaLibros()
            mostrarMensajeClasesAbstractas(descMostrar)
        }



    }

    private fun mostrarMensajeGestionErrores(textView: TextView) {
        val mensaje = "Se está utilizando gestión de errores y excepciones para manejar posibles errores durante el préstamo del libro " +
                "Se esta utilizando Metodos como Throw Exception para verificar si el libro ya esta prestado y asi prevenir que un libro que no se encuentra, pueda ser nuevamente prestado" +
                "Se utiliza Try y Catch ya que en este caso, se está intentando encontrar un libro en la lista de libros con un título específico para prestarlo. Sin embargo, pueden ocurrir varios escenarios que podrían generar excepciones:\n" +
                "\n" +
                "El libro con el título especificado no está en la lista de libros.\n" +
                "El libro está en la lista, pero ya está prestado.\n" +
                "Otros errores inesperados podrían ocurrir durante la ejecución.\n" +
                "El try-catch permite capturar estas excepciones y manejarlas de manera adecuada. Si se produce una excepción durante la ejecución del código dentro del bloque try, el control se transfiere al bloque catch, donde se puede manejar la excepción mostrando un mensaje de error al usuario, por ejemplo, o realizando cualquier otra acción apropiada. Esto ayuda a que la aplicación no se bloquee y proporcione una experiencia más fluida al usuario."
        textView.text = mensaje
    }

    private fun mostrarMensajeDevolver(textView: TextView){
        val mensaje = "La gestión de errores que se esta utilizando en la función devolverLibro se basa en el uso de una declaración try-catch. Esto  permite capturar cualquier excepción que pueda ocurrir durante la ejecución del código dentro del bloque try. Si se produce una excepción, en lugar de que la aplicación se bloquee, la capturamos en el bloque catch y podemos manejarla de manera apropiada, como mostrando un mensaje de error al usuario."
        textView.text = mensaje
    }
    private fun mostrarMensajeEncapsulamiento(textView: TextView) {
        val mensaje = "Para Agregar un nuevo libro se está utilizando encapsulamiento para proteger los datos del libro. " +
                "La clase Libro tiene atributos privados y métodos públicos para acceder y modificar estos atributos."
        textView.text = mensaje
    }
    private fun mostrarMensajeClasesAbstractas(textView: TextView) {
        val mensaje = "Se está utilizando encapsulamiento y clases abstractas para definir la estructura de la biblioteca"
        textView.text = mensaje
    }

    class Libro(private var titulo: String, private var autor: String, private var desc: String) {

        private var prestado: Boolean = false
        // Métodos públicos para acceder a los atributos
        fun getTitulo(): String {
            return titulo
        }

        fun setTitulo(nuevoTitulo: String) {
            titulo = nuevoTitulo
        }

        fun getAutor(): String {
            return autor
        }

        fun setAutor(nuevoAutor: String) {
            autor = nuevoAutor
        }

        fun getdesc() : String {
            return desc
        }

        fun setdesc(nuevaDesc: String) {
            desc = nuevaDesc
        }

        fun isPrestado(): Boolean {
            return prestado
        }

        fun prestar() {
            if (prestado) {
                throw Exception("El libro ya está prestado.")
            }
            prestado = true
        }

        fun devolver() {
            prestado = false
        }

        override fun toString(): String {
            return "Libro(titulo='$titulo', autor='$autor', descripción=$desc)"
        }
    }

    private fun mostrarDialogoLibroAgregado(libro: Libro) {
        val mensaje = "El libro ha sido agregado exitosamente a la colección:\n\n" +
                "Título: ${libro.getTitulo()}\n" +
                "Autor: ${libro.getAutor()}\n" +
                "Descripción: ${libro.getdesc()}\n\n" +
                "Gracias por contribuir a nuestra biblioteca."
        AlertDialog.Builder(this)
            .setTitle("Libro Agregado")
            .setMessage(mensaje)
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .show()
    }

    private fun prestarLibro(titulo: String) {
        val libro = listaLibros.find { it.getTitulo().equals(titulo, ignoreCase = true) }
        libro?.let {
            it.prestar()
            mostrarDialogoExito("El libro '${it.getTitulo()}' se le ha prestado exitosamente !Recuerde entregarlo!.")
        } ?: throw Exception("El libro con título '$titulo' no se encontró en la colección.")
    }

    private fun devolverLibro(titulo: String) {
        val libro = listaLibros.find { it.getTitulo().equals(titulo, ignoreCase = true) }
        libro?.let {
            it.devolver()
            mostrarDialogoExito("El libro '${it.getTitulo()}' ha sido devuelto exitosamente.")
        } ?: throw Exception("El libro con título '$titulo' no se encontró en la colección, por lo tanto no es un libro que se haya prestado.")
    }
    private fun mostrarDialogoError(mensaje: String) {
        AlertDialog.Builder(this)
            .setTitle("Error")
            .setMessage(mensaje)
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .show()
    }

    private fun mostrarDialogoExito(mensaje: String) {
        AlertDialog.Builder(this)
            .setTitle("Éxito")
            .setMessage(mensaje)
            .setPositiveButton("Aceptar") { dialog, _ -> dialog.dismiss() }
            .show()
    }

    private fun mostrarListaLibros() {
        val librosDisponibles = listaLibros.filter { !it.isPrestado() }

        if (librosDisponibles.isNotEmpty()) {
            val librosStr = StringBuilder()
            librosDisponibles.forEachIndexed { index, libro ->
                librosStr.append("Libro ${index + 1}: \n")
                librosStr.append("Título: ${libro.getTitulo()}\n")
                librosStr.append("Autor: ${libro.getAutor()}\n")
                librosStr.append("Descripción: ${libro.getdesc()}\n\n")
            }

            AlertDialog.Builder(this)
                .setTitle("Libros Disponibles")
                .setMessage(librosStr.toString())
                .setPositiveButton("Aceptar") { dialog, _ -> dialog.dismiss() }
                .show()
        } else {
            mostrarDialogoExito("No hay libros disponibles en la biblioteca en este momento.")
        }
    }


}