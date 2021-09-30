package resources;

import java.util.ArrayList;
import java.util.List;
import pojo.CreateBitLink;

public class TestDataBuild {	
	
	public CreateBitLink createBitLinkPayLoad(String longURL, String groupID)
	{
		List<String> tagsList =new ArrayList<String>();
		tagsList.add("bitly");
		tagsList.add("api");
		
		CreateBitLink p =new CreateBitLink();
		p.setLong_url(longURL);
		p.setDomain("bit.ly");
		p.setGroup_guid(groupID);
		p.setTitle("Bitly API Documentation");
		p.setTags(tagsList);

		return p;
	}

}
