package edu.upc.eetac.dsa.yifeige.Car_api.model;

public class Posicion 
{
	private int idposicion;
	private String username;
	private double coordenadaX;
	private double coordenadaY;
	private String descripcion;
	private long fecha;
	
	
	
	public int getIdposicion() 
	{
		return idposicion;
	}
	public void setIdposicion(int idposicion) 
	{
		this.idposicion = idposicion;
	}
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public double getCoordenadaX() {
		return coordenadaX;
	}
	public void setCoordenadaX(double coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	public double getCoordenadaY() {
		return coordenadaY;
	}
	public void setCoordenadaY(double coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	public String getDescripcion() 
	{
		return descripcion;
	}
	public void setDescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	}
	public long getFecha() {
		return fecha;
	}
	public void setFecha(long fecha) 
	{
		this.fecha = fecha;
	}


}
