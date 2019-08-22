package org.jbpm;

import java.util.*;

import javax.enterprise.context.Dependent;

import org.kie.workbench.common.forms.dynamic.model.config.SelectorData;
import org.kie.workbench.common.forms.dynamic.model.config.SelectorDataProvider;
import org.kie.workbench.common.forms.dynamic.service.shared.FormRenderingContext;


@Dependent
public class MySelectorDataProvider implements SelectorDataProvider {
	
	public String getProviderName() {
		return getClass().getSimpleName();
	}

	public SelectorData getSelectorData(FormRenderingContext context) {
		System.out.println ("Ingresou en getSelectorData");
		Map<String, String> values = new HashMap<String, String>();
		values.put("1", "valor-1");
		values.put("2", "valor-2");
		values.put("3", "valor-3");
		return new SelectorData<String>(values, null);
	}
}

