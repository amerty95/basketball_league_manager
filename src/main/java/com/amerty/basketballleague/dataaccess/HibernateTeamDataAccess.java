package com.amerty.basketballleague.dataaccess;

import com.amerty.basketballleague.entity.Team;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HibernateTeamDataAccess implements ITeamDataAccess{

    private EntityManager entityManager;

    @Autowired
    public HibernateTeamDataAccess(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Team> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Team> teams = session.createQuery("from Team", Team.class).getResultList();
        return teams;
    }

    @Override
    @Transactional
    public Team getTeam(String teamName) {
        Session session = entityManager.unwrap(Session.class);
        String queryText = "from Team T where T.teamName = :team_name";
        Query query = session.createQuery(queryText, Team.class);
        query.setParameter("team_name", teamName);
        Team team = (Team) query.list().get(0);
        return team;
    }

    @Override
    public List<Team> getTeams() {
        Session session = entityManager.unwrap(Session.class);
        String queryText = "from Team T order by pointCount desc";
        Query query = session.createQuery(queryText, Team.class);
        List<Team> teams = query.list();
        return teams;
    }
    @Override
    @Transactional
    public void update(Team team) {
        Session session = entityManager.unwrap(Session.class);
        session.update(team);
    }
}
