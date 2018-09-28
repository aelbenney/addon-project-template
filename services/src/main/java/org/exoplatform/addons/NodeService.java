package org.exoplatform.addons;

import org.exoplatform.container.ExoContainer;
import org.exoplatform.container.ExoContainerContext;
import org.exoplatform.services.jcr.RepositoryService;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.picocontainer.Startable;

import javax.jcr.*;


public class NodeService  implements Startable {
    private static final Log LOG = ExoLogger.getLogger(MyService.class);
    private RepositoryService repositoryService;


    public NodeService(){
    }
 /*   public void creeateNode() {
    }*/
    @Override
    public void start() {
        ExoContainer myContainer = ExoContainerContext.getCurrentContainer();
        RepositoryService repositoryService = (RepositoryService) myContainer. getComponentInstanceOfType(RepositoryService.class);
        LOG.info("*************************repo1*********************");
        Repository repository = null;
        try {
            repository = repositoryService.getCurrentRepository();
            Credentials credentials = new SimpleCredentials("root", "gtn".toCharArray());
            Session jcrSession = repository.login(credentials, "collaboration");
            LOG.info(jcrSession);
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        LOG.info(" ############################# node stopped");
    }



}
