public class AnimationAction extends Action{

    AnimationAction(ActionKind kind, Entity entity, WorldModel world, ImageStore imageStore, int repeatCount){
        super(kind, entity, world, imageStore, repeatCount);
    }

    public static Action createAnimationAction(Entity entity, int repeatCount) {
        return new Action(ActionKind.ANIMATION, entity, null, null, repeatCount);
    }

    /**
     * Ask the EventScheduler to execute an animation action for this action's Entity. This entails
     * telling the Entity to cycle through its images (each animation is one step through its images).
     *
     * @param scheduler The scheduler that queues up events.
     */
    public void executeAnimationAction(EventScheduler scheduler) {
        this.getEntity().nextImage();

        if (this.getRepeatCount() != 1) {
            scheduler.scheduleEvent(this.getEntity(), createAnimationAction(this.getEntity(), Math.max(this.getRepeatCount() - 1, 0)), this.getEntity().getAnimationPeriod());
        }
    }

    public void executeAction(EventScheduler scheduler) {
        this.executeAnimationAction(scheduler);
    }
}
