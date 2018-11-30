package com.vitgon.schedulehib.service.impl;

import java.util.List;

import com.vitgon.schedulehib.model.Group;
import com.vitgon.schedulehib.repository.GroupRepository;
import com.vitgon.schedulehib.service.GroupService;

public class GroupServiceImpl implements GroupService {
	
	private final GroupRepository groupRep;
	
	public GroupServiceImpl(GroupRepository groupRep) {
		this.groupRep = groupRep;
	}
	
	@Override
	public Group findByTitle(String title) {
		return groupRep.findByTitle(title);
	}

	@Override
	public Integer save(Group obj) {
		return groupRep.save(obj);
	}

	@Override
	public void update(Group obj) {
		groupRep.update(obj);
	}

	@Override
	public Group findById(Integer id) {
		return groupRep.findById(id);
	}

	@Override
	public List<Group> findAll() {
		return groupRep.findAll();
	}

	@Override
	public Group saveAndReturnEntity(Group obj) {
		save(obj);
		return obj;
	}
}
