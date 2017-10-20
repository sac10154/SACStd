package jp.co.sacn.dao;

import java.util.List;

import jp.co.sacn.meta.GroupMeta;
import jp.co.sacn.model.Group;

import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Transaction;

public class GroupDao extends DaoBase<Group>{

	protected static GroupMeta meta = new GroupMeta();

    public void creates(List<Group> groupList) {
    	for(Group gp : groupList){
    		create(gp);
    	}
    }

    public Group create(Group group) {
    	Group gp = select(group.getGroupId());
    	if(gp != null){
    		group.setKey(gp.getKey());
    	}

        Transaction tx = Datastore.beginTransaction();
        put(group);
        tx.commit();
        return group;
    }

    public Group select(String groupId) {
        return Datastore.query(meta).filter(meta.groupId.equal(groupId)).asSingle();
    }

    public List<Group> selectList(Integer groupType) {
        return Datastore.query(meta).filter(meta.groupType.equal(groupType)).sort(meta.groupId.asc).asList();
    }
}
