package org.jbpm;

import java.util.*;

import org.jbpm.Clientes;

import javax.enterprise.context.Dependent;

import org.kie.workbench.common.forms.dynamic.model.config.SelectorData;
import org.kie.workbench.common.forms.dynamic.model.config.SelectorDataProvider;
import org.kie.workbench.common.forms.dynamic.service.shared.FormRenderingContext;

/*@Dependent
public class MySelectorDataProvider implements SelectorDataProvider {
	
	public String getProviderName() {
		return "values";
	}

	public SelectorData getSelectorData(FormRenderingContext context) {
	 
		System.out.println ("Ingresou en getSelectorData");
		SelectorData<String> selectorData = new SelectorData<String>();
		Map<String, String> values = new HashMap<String, String>();
		values.put("1", "valor-1");
		values.put("2", "valor-2");
		values.put("3", "valor-3");
		selectorData.setValues(values);

		return selectorData;
	}
}
*/

@Dependent
public class MySelectorDataProvider implements SelectorDataProvider {
	
	public String getProviderName() {
		return "values";
	}

	public SelectorData getSelectorData(FormRenderingContext context) {
		System.out.println ("Ingresou en getSelectorData");
		
		Clientes clientes = new Clientes();
		ArrayList<String> clinetes = (ArrayList<String>) clientes.select();
		
		SelectorData<String> selectorData = new SelectorData<String>();
		Map<String, String> values = new HashMap<String, String>();
		
		for(int i = 0; i<clinetes.size(); i++) {
			values.put(clinetes.get(i), clinetes.get(i));
			selectorData.setValues(values);
		}
		return selectorData;
	}

}

