package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Vista.interfaz;

import Modelo.juego;

public class controler implements ActionListener
{
	private interfaz vista;
	private juego juego;
	private String titulo = "TaTeTi MVC, puto el que lee";
	
	public controler(interfaz vista, juego modelo)
	{
		this.vista = vista;
		this.juego = modelo;
	}
	
	//Inicia los valores del jFrame VISTA con los datos del MODELO
    // tambien a�adimos el ActionListener a los botones de la VISTA
	public void iniciarVista()
	{
		vista.setTitle( this.titulo );
        vista.setLocationRelativeTo(null);
        this.vista.casilla1.addActionListener(this);
        this.vista.casilla2.addActionListener(this);
        this.vista.casilla3.addActionListener(this);
        this.vista.casilla4.addActionListener(this);
        this.vista.casilla5.addActionListener(this);
        this.vista.casilla6.addActionListener(this);
        this.vista.casilla7.addActionListener(this);
        this.vista.casilla8.addActionListener(this);
        this.vista.casilla9.addActionListener(this);
	}
	
	//La accion de los botones de la VISTA es capturado, asi como los valores
    //dependiendo del boton pulsado, se envia la informacion al modelo
    //y se espera la respuesta
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object boton = e.getSource();

        if( this.juego.ganador()== 0 )
        {
        if( boton == this.vista.casilla1 )
            this.vista.casilla1.setText( this.juego.setMovimiento(1) );
        else if(boton == this.vista.casilla2)
            this.vista.casilla2.setText( this.juego.setMovimiento(2) );
        else if(boton == this.vista.casilla3)
            this.vista.casilla3.setText( this.juego.setMovimiento(3) );
        else if(boton == this.vista.casilla4)
            this.vista.casilla4.setText( this.juego.setMovimiento(4) );
        else if(boton == this.vista.casilla5)
            this.vista.casilla5.setText( this.juego.setMovimiento(5) );
        else if(boton == this.vista.casilla6)
            this.vista.casilla6.setText( this.juego.setMovimiento(6) );
        else if(boton == this.vista.casilla7)
            this.vista.casilla7.setText( this.juego.setMovimiento(7) );
        else if(boton == this.vista.casilla8)
            this.vista.casilla8.setText( this.juego.setMovimiento(8) );
        else if(boton == this.vista.casilla9)
            this.vista.casilla9.setText( this.juego.setMovimiento(9) );
        if( this.juego.get_error())
            JOptionPane.showMessageDialog(null, "Error: la casilla ya esta marcada \n Perdiste tu turno");            

        this.vista.setTitle( this.titulo + this.juego.get_turno());

        }

        if( this.juego.ganador()== 1 )
            mensaje(" 'X' ");
        else if( this.juego.ganador()== 2 )
            mensaje(" 'O' ");
        else if( this.juego.ganador()== 3 )
            mensaje(" 'Es un empate' ");
	}
	
	
	//dependiendo de la respuesta del modelo, se muestra un mensaje al usuario
	private void mensaje(String s)
    {
           int seleccion = JOptionPane.showOptionDialog(null,"Gano el jugador " + s + "\n �Que desea hacer?", "Fin del juego",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,    // null para icono por defecto.
                       new Object[] { " Jugar otra vez ", " Salir de Programa " },
                       "Jugar otra vez");

            if (seleccion != -1)
                if( (seleccion+1)==1 )
                {
                    this.juego.jugarOtraVez();
                    this.vista.setTitle(titulo);
                    this.vista.casilla1.setText( "" );
                    this.vista.casilla2.setText( "" );
                    this.vista.casilla3.setText( "" );
                    this.vista.casilla4.setText( "" );
                    this.vista.casilla5.setText( "" );
                    this.vista.casilla6.setText( "" );
                    this.vista.casilla7.setText( "" );
                    this.vista.casilla8.setText( "" );
                    this.vista.casilla9.setText( "" );
                }
                else
                    System.exit(0);
    }
}