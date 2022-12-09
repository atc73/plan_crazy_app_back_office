package com.example.plan_crazy_app_back_office.dao;

import com.example.plan_crazy_app_back_office.connection.PersistenceManager;
import com.example.plan_crazy_app_back_office.model.AppUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserDao implements Dao<AppUser>{

    EntityManagerFactory emf = PersistenceManager.getEntityManager();

    @Override
    public List<AppUser> getAll() {
        List<AppUser> appUserList = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            TypedQuery<AppUser> query = em.createQuery("SELECT b FROM AppUser b", AppUser.class);
            appUserList = query.getResultList();
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return appUserList;
    }



    @Override
    public void save(AppUser appUser) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(appUser);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        System.out.println("Je suis dans le findById");
        System.out.println(id);
        try {
            et.begin();
            AppUser appUser = em.createQuery("SELECT b FROM AppUser b  WHERE b.id = :idParam", AppUser.class)
                    .setParameter("idParam", id)
                    .getSingleResult();
            et.commit();
            return Optional.of(appUser);
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return Optional.empty();
    }


    @Override
    public void update(AppUser appUserUpdate) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Long id = appUserUpdate.getUserId();

        try {
            et.begin();
            AppUser appUser = em.find(AppUser.class, id);

            if (Objects.equals(appUser.getUserId(), appUserUpdate.getUserId())) {
                appUser.setAddress(appUserUpdate.getAddress());
                appUser.setPostcode(appUserUpdate.getPostcode());
                appUser.setCity(appUserUpdate.getCity());
                appUser.setPhoneNumber(appUserUpdate.getPhoneNumber());
                appUser.setEmail(appUserUpdate.getEmail());
            }
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }


    @Override
    public void delete(AppUser appUserToDelete) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            AppUser appUser = em.find(AppUser.class, appUserToDelete.getAppUserId());
            em.remove(appUser);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }
}
