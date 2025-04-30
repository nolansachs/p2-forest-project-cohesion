public class ActivityAction extends Action{

    ActivityAction(ActionKind kind, Entity entity, WorldModel world, ImageStore imageStore, int repeatCount){
        super(kind, entity, world, imageStore, repeatCount);
    }

    public static Action createActivityAction(Entity entity, WorldModel world, ImageStore imageStore) {
        return new Action(ActionKind.ACTIVITY, entity, world, imageStore, 0);
    }

    /**
     * Ask the EventScheduler to execute an activity action for this action's Entity.
     * This entails telling the Entity to execute its activity.
     *
     * @param scheduler The scheduler that queues up events.
     */
    public void executeActivityAction(EventScheduler scheduler) {
        switch (this.getEntity().getKind()) {
            case SAPLING -> this.getEntity().executeSaplingActivity(this.getWorld(), this.getImageStore(), scheduler);
            case TREE -> this.getEntity().executeTreeActivity(this.getWorld(), this.getImageStore(), scheduler);
            case FAIRY -> this.getEntity().executeFairyActivity(this.getWorld(), this.getImageStore(), scheduler);
            case DUDE_NOT_FULL -> this.getEntity().executeDudeNotFullActivity(this.getWorld(), this.getImageStore(), scheduler);
            case DUDE_FULL -> this.getEntity().executeDudeFullActivity(this.getWorld(), this.getImageStore(), scheduler);
            default ->
                    throw new UnsupportedOperationException(String.format("executeActivityAction not supported for %s", this.getEntity().getKind()));
        }
    }

//    public void executeAction(EventScheduler scheduler) {
//            this.executeActivityAction(scheduler);
//        }
}
