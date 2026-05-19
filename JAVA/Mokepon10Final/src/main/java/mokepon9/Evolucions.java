package mokepon9;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="evolucions")
//l'ordre en que apareixeran els seus elements interns en el XML
@XmlType(propOrder = { "pre_evolucio", "post_evolucio" })

public class Evolucions {
	
	private String pre_evolucio;
	private String post_evolucio;
	
	public Evolucions() {
		super();
	}

	public Evolucions(String pre_evolucio, String post_evolucio) {
		super();
		this.pre_evolucio = pre_evolucio;
		this.post_evolucio = post_evolucio;
	}
	@XmlElement
	public String getPre_evolucio() {
		return pre_evolucio;
	}

	public void setPre_evolucio(String pre_evolucio) {
		this.pre_evolucio = pre_evolucio;
	}
	@XmlElement
	public String getPost_evolucio() {
		return post_evolucio;
	}

	public void setPost_evolucio(String post_evolucio) {
		this.post_evolucio = post_evolucio;
	}

	@Override
	public String toString() {
		return "Evolucions [pre_evolucio=" + pre_evolucio + ", post_evolucio=" + post_evolucio + "]";
	}
	
	
	

}
