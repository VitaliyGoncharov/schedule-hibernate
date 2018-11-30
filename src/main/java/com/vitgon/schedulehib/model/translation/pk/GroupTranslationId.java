package com.vitgon.schedulehib.model.translation.pk;

import java.io.Serializable;
import java.util.Objects;

import com.vitgon.schedulehib.model.Group;
import com.vitgon.schedulehib.model.Locale;

public class GroupTranslationId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6221021972068258200L;
	private Group group;
	private Locale locale;
	
	public GroupTranslationId() {
	}
	
	public GroupTranslationId(Group group, Locale locale) {
		super();
		this.group = group;
		this.locale = locale;
	}

	public Group getGroup() {
		return group;
	}
	public Locale getLocale() {
		return locale;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getGroup(), getLocale());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof GroupTranslationId)) return false;
		GroupTranslationId that = (GroupTranslationId) obj;
		return Objects.equals(getGroup(), that.getGroup()) &&
				Objects.equals(getLocale(), that.getLocale());
	}
}
