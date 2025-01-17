package co.gov.dane.framework.transf;


import java.util.ArrayList;
import java.util.List;

public abstract class AdaptadorBase<DTO, Modelo> {

	public abstract DTO transformDTO(Modelo modelo);

	public abstract Modelo transformModel(DTO dto);

	public List<DTO> transformListDTO(List<Modelo> lstModel) {
		List<DTO> lstDTO = new ArrayList<DTO>();

		if (lstModel != null) {

			for (Modelo model : lstModel) {
				lstDTO.add(transformDTO(model));
			}

		}

		return lstDTO;
	}

	public List<Modelo> transformListModel(List<DTO> lstDTO) {

		List<Modelo> lstModel = new ArrayList<Modelo>();

		if (lstDTO != null) {

			for (DTO dto : lstDTO) {
				lstModel.add(transformModel(dto));
			}

		}

		return lstModel;
	}

}

