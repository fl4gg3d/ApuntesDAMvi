package decoratorClasseAbstracta;

public abstract class Decorador extends Component {

	private Component component;
	
	public Decorador (Component component) {
		this.component = component;
	}
	
	@Override
	public void operacio() {
		component.operacio();		
	}
}
