package ec.edu.ups.jakarta.dao;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

import ec.edu.ups.jakarta.models.Candidate;

@Stateless
public class CandidateDAO {

    @PersistenceContext
    private EntityManager em;

    
    public void save(Candidate candidate) {
        em.persist(candidate);
    }

    public Candidate findByCedula(String cedula) {
        TypedQuery<Candidate> query = em.createQuery("SELECT u FROM Candidate u WHERE u.cedula = :cedula", Candidate.class);
        query.setParameter("cedula", cedula);
        List<Candidate> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }


    public List<Candidate> findAll() {
        return em.createQuery("SELECT u FROM candidate u", Candidate.class).getResultList();
    }
}