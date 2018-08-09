package com.itec.clinic.dao;

import com.itec.clinic.entity.Page;
import com.itec.clinic.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class PersonDaoImpl implements PersonDao{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.openSession();
    }

    @Override
    public Person login(Person entity) {
        String username = entity.getUsername();
        String hql = "from Person as p where p.username = ?";
        Person person = (Person) getSession().createQuery(hql)
                .setParameter(0,username)
                .uniqueResult();//hibernate的下标从0开始 如果返回值只有一个 使用uniqueResult方法
        return person;
    }

    @Override
    public String add(Person entity) {
        Session session = this.getSession();

        Transaction tx = session.beginTransaction();
        String id =(String) session.save(entity); //事务应该在配置文件中配置好了
        tx.commit();//不提交就会无法插入数据库
        return id;
    }

    @Override
    public Person get(String id) {
        return getSession().get(Person.class,id);
    }

    @Override
    public Person load(String id) {
        return  getSession().load(Person.class,id);
    }

    @Override
    public List<Person> findAll() {
        List<Person> list = getSession().createQuery("from Person").list();//Person是类名
        return list;
    }

    @Override
    public void update(Person entity) {
        Session session = this.getSession();
        Transaction tx = session.beginTransaction();
        session.update(entity);
        tx.commit();
    }

//    @Override
//    public void saveOrUpdate(Person entity) {
//        getSession().saveOrUpdate(entity);
//    }

    @Override
    public void delete(String id) {
        Session session = this.getSession();

        Transaction tx = session.beginTransaction();
        session.delete(this.get(id));
        tx.commit();
    }

    /*模糊查询*/
    @Override
    public List<Person> searchByName(String name) {
        String hql = "from Person as p where p.name like '%"+name+"%'";
        List<Person> list= getSession().createQuery(hql).list();//下标从0开始 createQuery()返回的是query 要list()
        return list;
    }

    /*分页查询*/
    @Override
    public List<Person> findByPage(Page page) {
        Session session = this.getSession();
        String hql = "from Person";
        Query querypage = session.createQuery(hql);
        querypage.setMaxResults(page.getPageSize());//查询最大记录数
        querypage.setFirstResult(page.getBeginIndex());//查询起点
        List<Person> list = querypage.list();//分页查询
        return list;
    }

    @Override
    public int getTotalCount() {
        Session session = this.getSession();
        String hql = "select count(*) from Person";//查询总记录数
        Query querycount = session.createQuery(hql);
        Integer totalCount = Integer.parseInt(querycount.uniqueResult().toString());//返回Long型总条数
        return totalCount;
    }
    /*分页查询结束*/
}
