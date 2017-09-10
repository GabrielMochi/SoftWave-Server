package br.net.softwave.server.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;

import br.net.softwave.server.entity.AreaConhecimentoEntity;
import br.net.softwave.server.http.AreaConhecimento;
import br.net.softwave.server.repository.AreaConhecimentoRepository;

@Path("areaConhecimento")
public class AreaConhecimentoService extends Service<AreaConhecimento, AreaConhecimentoEntity, Integer> {

	public AreaConhecimentoService() {
		super(new AreaConhecimentoRepository());
	}

	@Override
	public void salvar(AreaConhecimento object) throws Exception {
		AreaConhecimentoEntity areaConhecimentoEntity = new AreaConhecimentoEntity();
		areaConhecimentoEntity.setNome(object.getNome());
		areaConhecimentoEntity.setEnderecoImagem(object.getEnderecoImagem());
		getRepository().salvar(areaConhecimentoEntity);		
	}

	@Override
	public void alterar(AreaConhecimento object) throws Exception {
		AreaConhecimentoEntity areaConhecimentoEntity = new AreaConhecimentoEntity();
		areaConhecimentoEntity.setId(object.getId());
		areaConhecimentoEntity.setNome(object.getNome());
		areaConhecimentoEntity.setEnderecoImagem(object.getEnderecoImagem());
		getRepository().alterar(areaConhecimentoEntity);
	}

	@Override
	public List<AreaConhecimento> pegarTodos() throws Exception {
		List<AreaConhecimento> areasConhecimentos = new ArrayList<>();
		List<AreaConhecimentoEntity> areaConhecimentoEntities = getRepository().pegarTodos("SELECT ac FROM AreaConhecimentoEntity ac");
		
		for (AreaConhecimentoEntity areaConhecimento : areaConhecimentoEntities) {
			areasConhecimentos.add(new AreaConhecimento(areaConhecimento.getId(), areaConhecimento.getNome(), areaConhecimento.getEnderecoImagem()));
		}
		
		return areasConhecimentos;
	}

	@Override
	public AreaConhecimento pegar(Integer id) throws Exception {
		AreaConhecimentoEntity areaConhecimentoEntity = getRepository().pegar(id);
		
		if (areaConhecimentoEntity != null) {
			return new AreaConhecimento(areaConhecimentoEntity.getId(), areaConhecimentoEntity.getNome(), areaConhecimentoEntity.getEnderecoImagem());
		}
		
		return null;
	}

	@Override
	public void remover(Integer id) throws Exception {
		getRepository().remover(id);
	}

}
