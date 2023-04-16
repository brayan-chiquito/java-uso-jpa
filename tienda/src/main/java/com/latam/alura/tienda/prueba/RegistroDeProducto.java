package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAutils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		/*
		Categoria celulares = new Categoria("CELULARES");
		Producto celular = new Producto("Samsung", "telefono usado", new BigDecimal("1000"),celulares);
		
		EntityManager em = JPAutils.getEntityManager();  // iniciar conexion
		ProductoDao productoDao = new ProductoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
//		
//		em.getTransaction().begin(); // iniciar transaccion
//		
//		categoriaDao.guardar(celulares);
//		productoDao.guardar(celular);
//		
//		em.getTransaction().commit();	//enviar transaccion BD
//		
//		em.close();						//cerrar transaccion
//		
		
		em.getTransaction().begin(); // iniciar transaccion
		
		em.persist(celulares);
		celulares.setNombre("LIBROS");
		
		em.flush();;	//enviar transaccion BD
		em.clear();						//cerrar transaccion
		celulares = em.merge(celulares);
		celulares.setNombre("SOFTWARE");
		em.flush();						//aun esta en estado manage
		em.clear(); 					//pasa a estado detached
		
		celulares = em.merge(celulares);
		em.remove(celulares);
		em.flush();
		*/
		registrarProducto();
		
		EntityManager em = JPAutils.getEntityManager();  // iniciar conexion
		ProductoDao productoDao = new ProductoDao(em);
		Producto producto = productoDao.consultaPorId(1l);
		System.out.println(producto.getNombre());
		
		BigDecimal precio = productoDao.cosultarPrecioPorNombre("Xiaomi Redmi");
		//productos.forEach(pro -> System.out.println(pro.getDescripcion()));
		System.out.println(precio);
	}

	private static void registrarProducto() {
		Categoria celulares = new Categoria("CELULARES");
		Producto celular = new Producto("Xiaomi Redmi", "Muy bueno", new BigDecimal("800"), celulares);
		EntityManager em = JPAutils.getEntityManager();  // iniciar conexion
		ProductoDao productoDao = new ProductoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin(); // iniciar transaccion
		
		categoriaDao.guardar(celulares);
		productoDao.guardar(celular);
		
		em.getTransaction().commit();	//enviar transaccion BD
		
		em.close();
	}

}
