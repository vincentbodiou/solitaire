package presentation;

public enum Decalage
{
	BAS(0, 30), DROITE(30, 0), SANS_DECALAGE(0, 0);

	private int dx;
	private int dy;

	/** Constructeur */
	private Decalage(int dx, int dy)
	{
		this.dx = dx;
		this.dy = dy;
	}

	public int getDx()
	{
		return this.dx;
	}

	public int getDy()
	{
		return this.dy;
	}
}
