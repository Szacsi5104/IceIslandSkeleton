package projlab.iceisland.model;

import projlab.iceisland.model.thingusagestrategies.BarehandsDig;
import projlab.iceisland.model.thingusagestrategies.RopeRescue;
import projlab.iceisland.model.thingusagestrategies.ShovelDig;

public enum Thing {

    Nothing{
        @Override
        DiggingStrategy getDiggingStrategy() {
            return new BarehandsDig();
        }

        @Override
        RescueStrategy getRescueStrategy() {
            return cantRescue;
        }

        @Override
        boolean useForSwimming() {
            return false;
        }
        @Override
        public void useForEating(Player who){

        }

        @Override
        void useForShooting(AbstractField from, IceIsland island) {

        }

    },
    Food{
        @Override
        DiggingStrategy getDiggingStrategy() {
            return new BarehandsDig();
        }

        @Override
        RescueStrategy getRescueStrategy() {
            return cantRescue;
        }

        @Override
        boolean useForSwimming() {
            return false;
        }

        @Override
        public void useForEating(Player who){
            who.ate();
        }

        @Override
        void useForShooting(AbstractField from, IceIsland island) {

        }
    }, Shovel{
        @Override
        DiggingStrategy getDiggingStrategy() {
            return new ShovelDig();
        }

        @Override
        RescueStrategy getRescueStrategy() {
            return cantRescue;
        }

        @Override
        boolean useForSwimming() {
            return false;
        }

        @Override
        public void useForEating(Player who){

        }

        @Override
        void useForShooting(AbstractField from, IceIsland island) {

        }
    }, Scuba{
        @Override
        DiggingStrategy getDiggingStrategy() {
            return new BarehandsDig();
        }

        @Override
        RescueStrategy getRescueStrategy() {
            return cantRescue;
        }

        @Override
        boolean useForSwimming() {
            return true;
        }

        @Override
        public void useForEating(Player who){

        }


        @Override
        void useForShooting(AbstractField from, IceIsland island) {

        }
    }, Rope{
        @Override
        DiggingStrategy getDiggingStrategy() {
            return new BarehandsDig();
        }

        @Override
        RescueStrategy getRescueStrategy() {
            return new RopeRescue();
        }

        @Override
        boolean useForSwimming() {
            return false;
        }

        @Override
        public void useForEating(Player who){

        }

        @Override
        void useForShooting(AbstractField from, IceIsland island) {

        }
    }, FlareGun{
        @Override
        DiggingStrategy getDiggingStrategy() {
            return new BarehandsDig();
        }

        @Override
        RescueStrategy getRescueStrategy() {
            return cantRescue;
        }

        @Override
        boolean useForSwimming() {
            return false;
        }

        @Override
        public void useForEating(Player who){

        }

        @Override
        void useForShooting(AbstractField from, IceIsland island) {
            if(island.isAssembleFlareGunPossible(from)){
                island.win();
            }


        }
    }, Cartridge{
        @Override
        DiggingStrategy getDiggingStrategy() {
            return new BarehandsDig();
        }

        @Override
        RescueStrategy getRescueStrategy() {
            return cantRescue;
        }

        @Override
        boolean useForSwimming() {
            return false;
        }

        @Override
        void useForEating(Player who) {

        }

        @Override
        void useForShooting(AbstractField from, IceIsland island) {
            if(island.isAssembleFlareGunPossible(from)){
                island.win();
            }

        }
    }, Beacon{
        @Override
        DiggingStrategy getDiggingStrategy() {
            return new BarehandsDig();
        }

        @Override
        RescueStrategy getRescueStrategy() {
            return cantRescue;
        }

        @Override
        boolean useForSwimming() {
            return false;
        }

        @Override
        public void useForEating(Player who){

        }

        @Override
        void useForShooting(AbstractField from, IceIsland island) {
            if(island.isAssembleFlareGunPossible(from)){
                island.win();
            }


        }
    };

    public interface DiggingStrategy{
        void dig(Player who);
    }

    public interface RescueStrategy {
        void rescuePlayer(Player who, int from);

    }

    public RescueStrategy cantRescue = (who , from)->{};

    abstract DiggingStrategy getDiggingStrategy();
    abstract RescueStrategy getRescueStrategy();
    abstract boolean useForSwimming();
    abstract void useForEating(Player who);
    abstract void useForShooting(AbstractField from, IceIsland island);
}
