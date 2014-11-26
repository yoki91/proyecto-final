package edu.upc.eetac.dsa.yifeige.Car_api;
import java.sql.*;
import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import edu.upc.eetac.dsa.yifeige.Car_api.model.Posicion;



@Path("/posicion")
public class PosicionResource 
{
	private DataSource ds = DataSourceSPA.getInstance().getDataSource();
	private String INSERT_POSICION_QUERY="insert into posiciones (username,coordenadaX,coordenadaY,descripcion) values(?,?,?,?)";
	
	
	
	
	@POST
	@Consumes(MediaType.CAR_API_POSICION)
	@Produces(MediaType.CAR_API_POSICION)
	public Posicion createPosicion(Posicion posicion)
	{
		Connection conn=null;
		try
		{
			conn=ds.getConnection();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		PreparedStatement stmt=null;
		try
		{
			stmt=conn.prepareStatement(INSERT_POSICION_QUERY,Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, posicion.getUsername());
			stmt.setDouble(2, posicion.getCoordenadaX());
			stmt.setDouble(3, posicion.getCoordenadaY());
			stmt.setString(4, posicion.getDescripcion());
			stmt.executeUpdate();
			ResultSet rs =stmt.getGeneratedKeys();
			
			if(rs.next())
			{
				int posicionid=rs.getInt(1);
				posicion=getPosicion(Integer.toString(posicionid));
			}
			else
			{
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if (stmt != null)
				stmt.close();
				conn.close();
			} 
			catch (SQLException e) 
			{
				
			}
		}
		
		
		return posicion;

		
	}
	
	
	
	private String GET_POSICION_BY_ID="select * from posiciones where idposicion=?";
	
	
	@GET
	@Path("/{posicionid}")
	@Produces(MediaType.CAR_API_POSICION)
	public Posicion getPosicion(@PathParam("posicionid") String posicionid)
	{
		Posicion posicion =new Posicion();
		Connection conn = null;
		try {
		conn = ds.getConnection();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		 
		PreparedStatement stmt = null; 
		try
		{
			stmt=conn.prepareStatement(GET_POSICION_BY_ID);
			stmt.setInt(1, Integer.valueOf(posicionid));
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{
				posicion.setIdposicion(rs.getInt("idposicion"));
				posicion.setUsername(rs.getString("username"));
				posicion.setCoordenadaX(rs.getDouble("coordenadaX"));
				posicion.setCoordenadaY(rs.getDouble("coordenadaY"));
				posicion.setDescripcion(rs.getString("descripcion"));
				posicion.setFecha(rs.getTimestamp("fecha").getTime());
			}
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		finally
		{
			try
			{
				if(stmt !=null)
			    stmt.close();
				
			}catch(SQLException e)
			{
				
			}
		}
		
		return posicion;
			
			
		
	}
	
	
	
	

}
