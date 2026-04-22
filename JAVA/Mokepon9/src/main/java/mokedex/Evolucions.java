package mokedex;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "pre_evolucio", "post_evolucio" })

public class Evolucions {

	String pre_evolucio;
	String post_evolucio;

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
}