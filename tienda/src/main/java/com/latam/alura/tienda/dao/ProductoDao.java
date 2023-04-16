package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Producto;


public class ProductoDao {
	
	private EntityManager em;

	public ProductoDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Producto producto) {
		this.em.persist(producto);
	}
	
	public Producto consultaPorId(long id) {
		return em.find(Producto.class, id);
	}
	
	public List<Producto> consultarTodos(){
		String jpql = "SELECT P FROM Producto AS P"; 	//asignar tipo y consulta
		return em.createQuery(jpql,Producto.class).getResultList();		//devolver el listado obtenido por el query
	}
	
	public List<Producto> consultarPorNombre(String nombre){
		String jpql = "SELECT P FROM Producto AS P WHERE P.nombre=:nombre";		//consulta por filtro y por nombre
		return em.createQuery(jpql,Producto.class).setParameter("nombre", nombre).getResultList();
	}
	
	public List<Producto> consultarPorNombreCategoria(String nombre){
		String jpql = "SELECT p FROM Producto AS p WHERE p.categoria.nombre=:nombre";
		return em.createQuery(jpql,Producto.class).setParameter("nombre", nombre).getResultList();
	}
	
	public BigDecimal cosultarPrecioPorNombre(String nombre) {
		String jpql="SELECT P.precio FROM Producto AS P WHERE P.nombre=:nombre";
		return em.createQuery(jpql,BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
	}
}
