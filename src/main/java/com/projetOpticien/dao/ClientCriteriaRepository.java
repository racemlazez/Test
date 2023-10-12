package com.projetOpticien.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.projetOpticien.model.Client;
import com.projetOpticien.model.ClientPage;
@Repository
public class ClientCriteriaRepository {
	 private final EntityManager entityManager ;
	    private final CriteriaBuilder criteriaBuilder;

	    public ClientCriteriaRepository(EntityManager entityManager) {
	        this.entityManager = entityManager;
	        this.criteriaBuilder = entityManager.getCriteriaBuilder();
	    }

	    public Page<Client> findAllWithFilters(ClientPage ClientPage,
	                                             String clientSearchCriteria){
	        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
	        Root<Client> clientRoot = criteriaQuery.from(Client.class);
	        Predicate predicate = getPredicate(clientSearchCriteria, clientRoot);
	        criteriaQuery.where(predicate);
	        setOrder(ClientPage, criteriaQuery, clientRoot);

	        TypedQuery<Client> typedQuery = entityManager.createQuery(criteriaQuery);
	        typedQuery.setFirstResult(ClientPage.getPageNumber() * ClientPage.getPageSize());
	        typedQuery.setMaxResults(ClientPage.getPageSize());

	        Pageable pageable = getPageable(ClientPage);

	        long ClientsCount = getClientsCount(predicate);

	        return new PageImpl<>(typedQuery.getResultList(), pageable, ClientsCount);
	    }

	    private Predicate getPredicate(String clientSearchCriteria,
	                                   Root<Client> ClientRoot) {
	        List<Predicate> predicates = new ArrayList<>();
	        if(Objects.nonNull(clientSearchCriteria)){
	            predicates.add(
	            		
	                    criteriaBuilder.like(ClientRoot.get("nomPrenom"),
	                            "%" + clientSearchCriteria + "%")
	            );
	        
	        
	            predicates.add(
	                    criteriaBuilder.like(ClientRoot.get("reference"),
	                            "%" + clientSearchCriteria + "%")
	            );
	        
	        
	        
	            predicates.add(
	                    criteriaBuilder.like(ClientRoot.get("observations"),
	                            "%" + clientSearchCriteria + "%")
	            );
	        
	            predicates.add(
	                    criteriaBuilder.like(ClientRoot.get("organisme"),
	                            "%" + clientSearchCriteria + "%")
	            );
	        
	        
	            predicates.add(
	                    criteriaBuilder.like(ClientRoot.get("groupe"),
	                            "%" + clientSearchCriteria + "%")
	            );
	            
               
	            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            sdf.setLenient(false);
	            try {
	            	
	                sdf.parse(clientSearchCriteria);
	            	LocalDate localDate = LocalDate.parse(clientSearchCriteria);
	                predicates.add(
		                    criteriaBuilder.equal( ClientRoot.get("dateNaissance"),
		                    		localDate)
		            );
	            } catch (ParseException e) {
	               
	            }
	          }
	        
	        return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
	    }

	    private void setOrder(ClientPage clientPage,
	                          CriteriaQuery<Client> criteriaQuery,
	                          Root<Client> ClientRoot) {
	        if(clientPage.getSortDirection().equals(Sort.Direction.ASC)){
	            criteriaQuery.orderBy(criteriaBuilder.asc(ClientRoot.get(clientPage.getSortBy())));
	        } else {
	            criteriaQuery.orderBy(criteriaBuilder.desc(ClientRoot.get(clientPage.getSortBy())));
	        }
	    }

	    private Pageable getPageable(ClientPage ClientPage) {
	        Sort sort = Sort.by(ClientPage.getSortDirection(), ClientPage.getSortBy());
	        return PageRequest.of(ClientPage.getPageNumber(),ClientPage.getPageSize(), sort);
	    }

	    private long getClientsCount(Predicate predicate) {
	        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
	        Root<Client> countRoot = countQuery.from(Client.class);
	        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
	        return entityManager.createQuery(countQuery).getSingleResult();
	    }
}
