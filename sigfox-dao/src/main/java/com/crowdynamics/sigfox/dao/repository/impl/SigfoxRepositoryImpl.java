package com.crowdynamics.sigfox.dao.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.crowdynamics.sigfox.dao.repository.SigfoxRepository;
import com.crowdynamics.sigfox.entity.SigfoxMessagesEntity;


@Repository
public class SigfoxRepositoryImpl implements SigfoxRepository {


		@Override
		public void deleteAllInBatch() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteInBatch(Iterable<SigfoxMessagesEntity> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<SigfoxMessagesEntity> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<SigfoxMessagesEntity> findAll(Sort arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends SigfoxMessagesEntity> List<S> findAll(Example<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends SigfoxMessagesEntity> List<S> findAll(Example<S> arg0, Sort arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<SigfoxMessagesEntity> findAllById(Iterable<Long> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void flush() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public SigfoxMessagesEntity getOne(Long arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends SigfoxMessagesEntity> List<S> saveAll(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends SigfoxMessagesEntity> S saveAndFlush(S arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Page<SigfoxMessagesEntity> findAll(Pageable arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void delete(SigfoxMessagesEntity arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll(Iterable<? extends SigfoxMessagesEntity> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteById(Long arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean existsById(Long arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Optional<SigfoxMessagesEntity> findById(Long arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends SigfoxMessagesEntity> S save(S arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends SigfoxMessagesEntity> long count(Example<S> arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public <S extends SigfoxMessagesEntity> boolean exists(Example<S> arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public <S extends SigfoxMessagesEntity> Page<S> findAll(Example<S> arg0, Pageable arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends SigfoxMessagesEntity> Optional<S> findOne(Example<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<SigfoxMessagesEntity> findOne(Long id) {
			// TODO Auto-generated method stub
			return null;
		}

	
	}

	

