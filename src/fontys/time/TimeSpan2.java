/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

/**
 *
 * @author Niels Molmans
 */
public class TimeSpan2 implements ITimeSpan{

    private ITime bt;
    private long timeSpan;
    
    public TimeSpan2(ITime bt, ITime et) {
        if (bt.compareTo(et) >= 0) {
            throw new IllegalArgumentException("begin time "
                    + bt + " must be earlier than end time " + et);
        }

        this.bt = bt;
        this.timeSpan = et.difference(bt);
    }
    @Override
    public ITime getBeginTime() {
        return bt;
    }

    @Override
    public ITime getEndTime() {
        return bt.plus((int)timeSpan);
    }

    @Override
    public int length() {
       ITime time = getEndTime();
        return time.difference(bt);
    }

    @Override
    public void setBeginTime(ITime beginTime) {
         ITime time = getEndTime();
        if (beginTime.compareTo(time) >= 0) {
            throw new IllegalArgumentException("begin time "
                    + bt + " must be earlier than end time " + time);
        }

        bt = beginTime;
    }

    @Override
    public void setEndTime(ITime endTime) {
         ITime time = getEndTime();
        if (endTime.compareTo(bt) <= 0) {
            throw new IllegalArgumentException("end time "
                    + time + " must be later then begin time " + bt);
        }

        time = endTime;
    }

    @Override
    public void move(int minutes) {
         ITime time = getEndTime();
        bt = bt.plus(minutes);
        time = time.plus(minutes);
    }

    @Override
    public void changeLengthWith(int minutes) {
         ITime time = getEndTime();
        if (minutes + length() <= 0) {
            throw new IllegalArgumentException("length of period must be positive");
        }
        
        time = time.plus(minutes);
    }

    @Override
    public boolean isPartOf(ITimeSpan timeSpan) {
        return (getBeginTime().compareTo(timeSpan.getBeginTime()) >= 0
                && getEndTime().compareTo(timeSpan.getEndTime()) <= 0);
    }

    @Override
    public ITimeSpan unionWith(ITimeSpan timeSpan) {
         ITime time = getEndTime();
        if (bt.compareTo(timeSpan.getEndTime()) < 0 || time.compareTo(timeSpan.getBeginTime()) > 0) {
            return null;
        }
        
        ITime begintime, endtime;
        if (bt.compareTo(timeSpan.getBeginTime()) < 0) {
            begintime = bt;
        } else {
            begintime = timeSpan.getBeginTime();
        }

        if (time.compareTo(timeSpan.getEndTime()) > 0) {
            endtime = time;
        } else {
            endtime = timeSpan.getEndTime();
        }

        return new TimeSpan(begintime, endtime);

    }

    @Override
    public ITimeSpan intersectionWith(ITimeSpan timeSpan) {
         ITime time = getEndTime();

        ITime begintime, endtime;
        if (bt.compareTo(timeSpan.getBeginTime()) > 0) {
            begintime = bt;
        } else {
            begintime = timeSpan.getBeginTime();
        }

        if (time.compareTo(timeSpan.getEndTime()) < 0) {
            endtime = time;
        } else {
            endtime = timeSpan.getEndTime();
        }

        if (begintime.compareTo(endtime) >= 0) {
            return null;
        }

        return new TimeSpan(begintime, endtime);
    }
    
}
