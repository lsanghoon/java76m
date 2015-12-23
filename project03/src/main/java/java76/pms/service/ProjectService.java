package java76.pms.service;

import java.util.List;

import java76.pms.domain.Project;

public interface ProjectService {
	
  public List<Project> getProjectList(
  		int pageNo, int pageSize, String keyword, String align);
  public void register(Project project);
  public void remove(int no);
  public void change(Project project);
  public Project retrieve(int no);
}







