/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.IGenericDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author lucas
 */
public class GenericDaoImpl<T, ID extends Serializable> implements IGenericDao<T, ID> {

    private Class<T> klass;
    private Session session = null;

    public GenericDaoImpl() {
    }

    public GenericDaoImpl(Class<T> klass) {

        this.klass = klass;
        //this.session = HibernateUtil.getSessionFactory().openSession();
        //this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        if(session == null){
            session = HibernateUtil.getSessionFactory().openSession();
        }else{
            session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        
    }

    public T findById(ID id) {
        T object = (T) session.get(klass, id);
        return object;
    }

    public void save(T object) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate((T) object);
        t.commit();
    }

    public void delete(T object) {
        Transaction t = session.beginTransaction();
        session.delete((T) object);
        t.commit();
    }

    public List<T> listAll() {
        Transaction t = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(klass);

        Root<T> klassRoot = query.from(klass);

        query.select(klassRoot)
                .where(builder.isNull(klassRoot.get("nome_professor")));

        List<T> result = session.createQuery(query).getResultList();

        System.out.println(session.isOpen());

        t.commit();

        System.out.println(session.isOpen());
      
        return result;

    }

    public List<T> findAllByMulti(Map<String, Object> condition) {

        Criteria criteria = session.createCriteria(klass);
        
        condition.forEach((k, v) -> {
            if (k != null) {
                criteria.add(Restrictions.eq(k, v));
            }
        });

        return (List<T>) criteria.list();
    }

    public List<T> findAllBy(String property, List<?> values) {
        return findAllBy(property, values, null);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAllBy(String property, List<?> values, Order order) {

        //this.session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(klass)
                .add(Restrictions.in(property, values));
        if (order != null) {
            criteria.addOrder(order);
        }
        transaction.commit();
        return (List<T>) criteria.list();
    }

    @SuppressWarnings("serial")
    public List<T> findAllBy(String property, final Object value) {
        return findAllBy(property, new ArrayList<Object>() {
            {
                add(value);
            }
        }, null);
    }

    public List<T> findAllBy(String property, final Object value, Order order) {
        return findAllBy(property, new ArrayList<Object>() {
            {
                add(value);
            }
        }, order);
    }

    public List<T> findAll() {
        return findAll(null);
    }

    public List<T> findAll(Order order) {

        //this.session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(klass);
        if (order != null) {
            criteria.addOrder(order);
        }
        transaction.commit();
        return (List<T>) criteria.list();
    }

    public T findBy(String property, final Object value) {
        List<T> results = findAllBy(property, value);
        if (results == null || results.isEmpty()) {
            return null;
        }
        return results.get(0);
    }
}
