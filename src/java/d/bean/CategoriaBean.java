/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.bean;

import com.model.pojos.Categoria;
import com.util.HibernateUtil;
import java.util.List;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author gaboqm
 */
@Named(value = "categoriaBean")
@RequestScoped
public class CategoriaBean {
    private String nombre;
    
    public CategoriaBean() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public List<Categoria> getCategoria(){
        //establece conexxion
        //session Factory
        //sessionFactory
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session ses=sf.openSession();
        //query hql
        List<Categoria> lista=ses.createQuery("from Categoria").list();
        //metodo dos
        List<Categoria> lista2=ses.createCriteria(Categoria.class).list();
        return lista;
    }
    public String guardar(){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session ses=sf.openSession();
        Transaction tx=ses.beginTransaction();
        Categoria cat= new Categoria(nombre);
        ses.save(cat);
        tx.commit();
        
        return "index";
    }
    
}
