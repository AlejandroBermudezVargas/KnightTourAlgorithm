public class NodoPila
{
	Object dato;
	NodoPila sgte;
	
	public NodoPila(Object dato)
	{
		this.dato = dato;
		sgte = null;
	}

	public void setSgte (NodoPila sgte)
	{
		this.sgte = sgte;
	}

	public NodoPila getSgte ()
	{
		return sgte;
	}

	public void setDato(Object dato)
	{
		this.dato = dato;
	}

	public Object getDato()
	{
		return dato;
	} 
}
