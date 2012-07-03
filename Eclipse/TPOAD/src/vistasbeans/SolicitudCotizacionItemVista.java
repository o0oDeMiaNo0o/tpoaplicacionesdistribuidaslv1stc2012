package vistasbeans;


public class SolicitudCotizacionItemVista {
	
		private int id;
		private int cantidad;
		private RodamientoVista rodamiento;
		private String estado;

		public String getEstado() {
			return estado;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		public RodamientoVista getRodamiento() {
			return rodamiento;
		}

		public void setRodamiento(RodamientoVista rodamiento) {
			this.rodamiento = rodamiento;
		}

}
