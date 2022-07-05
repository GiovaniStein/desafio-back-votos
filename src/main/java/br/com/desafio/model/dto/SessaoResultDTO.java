package br.com.desafio.model.dto;

public interface SessaoResultDTO  {
	
	String getNamePauta();
	String getDescription();
	Long getNumberApprovedVotes();
	Long getNumberDisapprovedVotes();
	Long getNumberVotes();

}
