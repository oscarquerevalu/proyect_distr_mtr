package gob.mtc.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlOutputFormat;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.event.ActionEvent;

import org.primefaces.component.column.Column;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.panelgrid.PanelGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import test.service.pojo.Person;
import test.service.user.mgtm.IUserMgmtService;

@Controller
@ManagedBean(name = "personMng")
@ViewScoped
public class PersonaBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IUserMgmtService mgmtService;
	
	private PanelGrid pnlGrid;
	private List<Person> personas;
	
	public PersonaBean(){
		personas = new ArrayList<Person>();
		System.out.println("PersonaBean");
		
		pnlGrid = new PanelGrid();
		
		HtmlOutputText text = new HtmlOutputText();
		
		text.setValue("obj");
		
		
		for (int i = 0; i < 5; i++) {
			DataTable table = new DataTable();
			
			Column column = new Column();
			
			column.setHeaderText("Persona " + i);
			
			table.getChildren().add(column);
			
			pnlGrid.getChildren().add(table);
		}
		
		pnlGrid.getChildren().add(text);
	}
	
	public void listar(ActionEvent event){
		try {
			personas.addAll(mgmtService.getPersonList());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Person> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Person> personas) {
		this.personas = personas;
	}

	public PanelGrid getPnlGrid() {
		return pnlGrid;
	}

	public void setPnlGrid(PanelGrid pnlGrid) {
		this.pnlGrid = pnlGrid;
	}
	
	
	

}
