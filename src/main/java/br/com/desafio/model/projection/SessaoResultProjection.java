package br.com.desafio.model.projection;

public interface SessaoResultProjection  {
	
	String getNamePauta();
	String getDescription();
	Long getNumberApprovedVotes();
	Long getNumberDisapprovedVotes();
	Long getNumberVotes();

}
