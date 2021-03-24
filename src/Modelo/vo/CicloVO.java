package Modelo.vo;

public class CicloVO {
	private Integer id;
    private String nombre;
    private int nivel;
    private String cursos;

    public CicloVO() {

    }

    public CicloVO(Integer id, String nombre,  int nivel, String cursos) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.cursos = cursos;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getCursos() {
		return cursos;
	}

	public void setCursos(String cursos) {
		this.cursos = cursos;
	}
    
    
}
