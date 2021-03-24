package Modelo.vo;


public class ModuloVO {
	 private Integer id;
	    private String nombre;
	    private int curso;
	    private int horas;
	    private int idCiclo;

	    public ModuloVO() {

	    }

	    public ModuloVO(Integer id, String nombre, int curso, int idCiclo, int horas) {
	        this.id = id;
	        this.nombre = nombre;
	        this.curso = curso;
	        this.idCiclo = idCiclo;
	        this.horas = horas;
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

	 

	   

	    public int getCurso() {
			return curso;
		}

		public void setCurso(int curso) {
			this.curso = curso;
		}

		public int getIdCiclo() {
			return idCiclo;
		}

		public void setIdCiclo(int idCiclo) {
			this.idCiclo = idCiclo;
		}

		public int getHoras() {
	        return horas;
	    }

	    public void setHoras(int horas) {
	        this.horas = horas;
	    }
}

