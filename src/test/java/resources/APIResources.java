package resources;
//enum is special class in java which has collection of constants or  methods
public enum APIResources {
	
	RetrieveGroupAPI("/v4/groups/Bl9s7SOtulG"),
	RetrieveGroupAPINeg("/v4/groups/Bl9s7SOtu"),
	AddBitLinkAPI("/v4/bitlinks"),
	RetrieveSortedBitlinksForGroup("/v4/groups/Bl9s7SOtulG/bitlinks/clicks"),
	RetrieveSortedBitlinksForGroupNeg("/v4/groups/Bl9s7SOt/bitlinks/clicks");
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
