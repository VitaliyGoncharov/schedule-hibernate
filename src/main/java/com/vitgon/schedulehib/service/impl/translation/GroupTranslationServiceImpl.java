package com.vitgon.schedulehib.service.impl.translation;

import java.util.List;

import com.vitgon.schedulehib.model.translation.GroupTranslation;
import com.vitgon.schedulehib.model.translation.pk.GroupTranslationId;
import com.vitgon.schedulehib.repository.translation.GroupTranslationRepository;
import com.vitgon.schedulehib.service.translation.GroupTranslationService;

public class GroupTranslationServiceImpl implements GroupTranslationService {

	private final GroupTranslationRepository groupTranslRep;
	
	public GroupTranslationServiceImpl(GroupTranslationRepository groupTranslRep) {
		this.groupTranslRep = groupTranslRep;
	}
	
	@Override
	public GroupTranslationId save(GroupTranslation obj) {
		return groupTranslRep.save(obj);
	}

	@Override
	public void update(GroupTranslation obj) {
		groupTranslRep.update(obj);
	}

	@Override
	public GroupTranslation findById(GroupTranslationId id) {
		return groupTranslRep.findById(id);
	}

	@Override
	public List<GroupTranslation> findAll() {
		return groupTranslRep.findAll();
	}
	
	@Override
	public GroupTranslation saveAndReturnEntity(GroupTranslation obj) {
		save(obj);
		return obj;
	}
}
