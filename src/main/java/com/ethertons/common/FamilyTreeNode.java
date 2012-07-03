package com.ethertons.common;

public class FamilyTreeNode {

    private String left;
    private String top;
    private String id;
    private String fullname;
    private String mlineDisplay;
    private String mlineTop;
    private String mlineLeft;

    public FamilyTreeNode(Spouse builder) {
        left = builder.left;
        top = builder.top;
        id = builder.id;
        fullname = builder.fullname;
        mlineDisplay = builder.mlineDisplay;
        mlineTop = builder.mlineTop;
        mlineLeft = builder.mlineLeft;
        mlineWidth = builder.mlineWidth;
        l1PlineDisplay = builder.l1PlineDisplay;
        l2PlineDisplay = builder.l2PlineDisplay;
        l3PlineDisplay = builder.l3PlineDisplay;
    }

    public FamilyTreeNode(Child builder) {
        left = builder.left;
        top = builder.top;
        id = builder.id;
        fullname = builder.fullname;
        mlineDisplay = builder.mlineDisplay;
        mlineTop = builder.mlineTop;
        mlineLeft = builder.mlineLeft;
    }

    public String getMlineWidth() {
        return mlineWidth;
    }

    public void setMlineWidth(String mlineWidth) {
        this.mlineWidth = mlineWidth;
    }

    private String mlineWidth;
    private String l1PlineDisplay;
    private String l2PlineDisplay;
    private String l3PlineDisplay;
    private String l1PlineLeft;
    private String l2PlineTop;
    private String l2PlineLeft;
    private String l3PlineTop;
    private String l3PlineLeft;

    public String getL1PlineTop() {
        return l1PlineTop;
    }

    public void setL1PlineTop(String l1PlineTop) {
        this.l1PlineTop = l1PlineTop;
    }

    private String l1PlineTop;

    public String getL1PlineLeft() {
        return l1PlineLeft;
    }

    public void setL1PlineLeft(String l1PlineLeft) {
        this.l1PlineLeft = l1PlineLeft;
    }

    public String getL2PlineTop() {
        return l2PlineTop;
    }

    public void setL2PlineTop(String l2PlineTop) {
        this.l2PlineTop = l2PlineTop;
    }

    public String getL2PlineLeft() {
        return l2PlineLeft;
    }

    public void setL2PlineLeft(String l2PlineLeft) {
        this.l2PlineLeft = l2PlineLeft;
    }

    public String getL3PlineTop() {
        return l3PlineTop;
    }

    public void setL3PlineTop(String l3PlineTop) {
        this.l3PlineTop = l3PlineTop;
    }

    public String getL3PlineLeft() {
        return l3PlineLeft;
    }

    public void setL3PlineLeft(String l3PlineLeft) {
        this.l3PlineLeft = l3PlineLeft;
    }


    public String getL1PlineWidth() {
        return l1PlineWidth;
    }

    public void setL1PlineWidth(String l1PlineWidth) {
        this.l1PlineWidth = l1PlineWidth;
    }

    public String getL2PlineWidth() {
        return l2PlineWidth;
    }

    public void setL2PlineWidth(String l2PlineWidth) {
        this.l2PlineWidth = l2PlineWidth;
    }

    public String getL3PlineWidth() {
        return l3PlineWidth;
    }

    public void setL3PlineWidth(String l3PlineWidth) {
        this.l3PlineWidth = l3PlineWidth;
    }

    private String l1PlineWidth;
    private String l2PlineWidth;
    private String l3PlineWidth;

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMlineDisplay() {
        return mlineDisplay;
    }

    public void setMlineDisplay(String mlineDisplay) {
        this.mlineDisplay = mlineDisplay;
    }

    public String getMlineTop() {
        return mlineTop;
    }

    public void setMlineTop(String mlineTop) {
        this.mlineTop = mlineTop;
    }

    public String getMlineLeft() {
        return mlineLeft;
    }

    public void setMlineLeft(String mlineLeft) {
        this.mlineLeft = mlineLeft;
    }

    public String getL1PlineDisplay() {
        return l1PlineDisplay;
    }

    public void setL1PlineDisplay(String l1PlineDisplay) {
        this.l1PlineDisplay = l1PlineDisplay;
    }

    public String getL2PlineDisplay() {
        return l2PlineDisplay;
    }

    public void setL2PlineDisplay(String l2PlineDisplay) {
        this.l2PlineDisplay = l2PlineDisplay;
    }

    public String getL3PlineDisplay() {
        return l3PlineDisplay;
    }

    public void setL3PlineDisplay(String l3PlineDisplay) {
        this.l3PlineDisplay = l3PlineDisplay;
    }

    @Override
    public String toString() {
        return "FamilyTreeNode{" +
                "left='" + left + '\'' +
                ", top='" + top + '\'' +
                ", id='" + id + '\'' +
                ", fullname='" + fullname + '\'' +
                ", mlineDisplay='" + mlineDisplay + '\'' +
                ", mlineTop='" + mlineTop + '\'' +
                ", mlineLeft='" + mlineLeft + '\'' +
                ", mlineWidth='" + mlineWidth + '\'' +
                ", l1PlineDisplay='" + l1PlineDisplay + '\'' +
                ", l2PlineDisplay='" + l2PlineDisplay + '\'' +
                ", l3PlineDisplay='" + l3PlineDisplay + '\'' +
                ", l1PlineLeft='" + l1PlineLeft + '\'' +
                ", l2PlineTop='" + l2PlineTop + '\'' +
                ", l2PlineLeft='" + l2PlineLeft + '\'' +
                ", l3PlineTop='" + l3PlineTop + '\'' +
                ", l3PlineLeft='" + l3PlineLeft + '\'' +
                ", l1PlineTop='" + l1PlineTop + '\'' +
                ", l1PlineWidth='" + l1PlineWidth + '\'' +
                ", l2PlineWidth='" + l2PlineWidth + '\'' +
                ", l3PlineWidth='" + l3PlineWidth + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FamilyTreeNode that = (FamilyTreeNode) o;

        if (fullname != null ? !fullname.equals(that.fullname) : that.fullname != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (l1PlineDisplay != null ? !l1PlineDisplay.equals(that.l1PlineDisplay) : that.l1PlineDisplay != null)
            return false;
        if (l1PlineLeft != null ? !l1PlineLeft.equals(that.l1PlineLeft) : that.l1PlineLeft != null) return false;
        if (l1PlineTop != null ? !l1PlineTop.equals(that.l1PlineTop) : that.l1PlineTop != null) return false;
        if (l1PlineWidth != null ? !l1PlineWidth.equals(that.l1PlineWidth) : that.l1PlineWidth != null) return false;
        if (l2PlineDisplay != null ? !l2PlineDisplay.equals(that.l2PlineDisplay) : that.l2PlineDisplay != null)
            return false;
        if (l2PlineLeft != null ? !l2PlineLeft.equals(that.l2PlineLeft) : that.l2PlineLeft != null) return false;
        if (l2PlineTop != null ? !l2PlineTop.equals(that.l2PlineTop) : that.l2PlineTop != null) return false;
        if (l2PlineWidth != null ? !l2PlineWidth.equals(that.l2PlineWidth) : that.l2PlineWidth != null) return false;
        if (l3PlineDisplay != null ? !l3PlineDisplay.equals(that.l3PlineDisplay) : that.l3PlineDisplay != null)
            return false;
        if (l3PlineLeft != null ? !l3PlineLeft.equals(that.l3PlineLeft) : that.l3PlineLeft != null) return false;
        if (l3PlineTop != null ? !l3PlineTop.equals(that.l3PlineTop) : that.l3PlineTop != null) return false;
        if (l3PlineWidth != null ? !l3PlineWidth.equals(that.l3PlineWidth) : that.l3PlineWidth != null) return false;
        if (left != null ? !left.equals(that.left) : that.left != null) return false;
        if (mlineDisplay != null ? !mlineDisplay.equals(that.mlineDisplay) : that.mlineDisplay != null) return false;
        if (mlineLeft != null ? !mlineLeft.equals(that.mlineLeft) : that.mlineLeft != null) return false;
        if (mlineTop != null ? !mlineTop.equals(that.mlineTop) : that.mlineTop != null) return false;
        if (mlineWidth != null ? !mlineWidth.equals(that.mlineWidth) : that.mlineWidth != null) return false;
        if (top != null ? !top.equals(that.top) : that.top != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = left != null ? left.hashCode() : 0;
        result = 31 * result + (top != null ? top.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (mlineDisplay != null ? mlineDisplay.hashCode() : 0);
        result = 31 * result + (mlineTop != null ? mlineTop.hashCode() : 0);
        result = 31 * result + (mlineLeft != null ? mlineLeft.hashCode() : 0);
        result = 31 * result + (mlineWidth != null ? mlineWidth.hashCode() : 0);
        result = 31 * result + (l1PlineDisplay != null ? l1PlineDisplay.hashCode() : 0);
        result = 31 * result + (l2PlineDisplay != null ? l2PlineDisplay.hashCode() : 0);
        result = 31 * result + (l3PlineDisplay != null ? l3PlineDisplay.hashCode() : 0);
        result = 31 * result + (l1PlineLeft != null ? l1PlineLeft.hashCode() : 0);
        result = 31 * result + (l2PlineTop != null ? l2PlineTop.hashCode() : 0);
        result = 31 * result + (l2PlineLeft != null ? l2PlineLeft.hashCode() : 0);
        result = 31 * result + (l3PlineTop != null ? l3PlineTop.hashCode() : 0);
        result = 31 * result + (l3PlineLeft != null ? l3PlineLeft.hashCode() : 0);
        result = 31 * result + (l1PlineTop != null ? l1PlineTop.hashCode() : 0);
        result = 31 * result + (l1PlineWidth != null ? l1PlineWidth.hashCode() : 0);
        result = 31 * result + (l2PlineWidth != null ? l2PlineWidth.hashCode() : 0);
        result = 31 * result + (l3PlineWidth != null ? l3PlineWidth.hashCode() : 0);
        return result;
    }

    public static class Spouse {
        private String left;
        private String top;
        private String id;
        private String fullname;
        private String mlineDisplay;
        private String mlineTop;
        private String mlineLeft;
        private String mlineWidth;
        private String l1PlineDisplay;
        private String l2PlineDisplay;
        private String l3PlineDisplay;
        private String l1PlineLeft;
        private String l2PlineTop;
        private String l2PlineLeft;
        private String l3PlineTop;
        private String l3PlineLeft;

        public Spouse left(String val) {
            left = val;
            return this;
        }

        public Spouse top(String val) {
            top = val;
            return this;
        }
        
        public Spouse id(String val) {
            id = val;
            return this;
        }
        
        public Spouse fullname(String val) {
            fullname = val;
            return this;
        }
        
        public Spouse mLineDisplay(String val) {
            mlineDisplay = val;
            return this;
        }
        
        public Spouse mLineTop(String val) {
            mlineTop = val;
            return this;
        }
        
        public Spouse mLineLeft(String val) {
            mlineLeft = val;
            return this;
        }
        
        public Spouse mLineWidth(String val) {
            mlineWidth = val;
            return this;
        }

        public Spouse l1PlineDisplay(String val) {
            l1PlineDisplay = val;
            return this;
        }
        
        public Spouse l2PlineDisplay(String val) {
            l2PlineDisplay = val;
            return this;
        }
        
        public Spouse l3PlineDisplay(String val) {
            l3PlineDisplay = val;
            return this;
        }

        public Spouse l1PlineLeft(String val) {
            l1PlineLeft = val;
            return this;
        }

        public Spouse l2PlineLeft(String val) {
            l2PlineLeft = val;
            return this;
        }

        public Spouse l3PlineLeft(String val) {
            l3PlineLeft = val;
            return this;
        }

        public Spouse l2PlineTop(String val) {
            l2PlineTop = val;
            return this;
        }

        public Spouse l3PlineTop(String val) {
            l3PlineTop = val;
            return this;
        }
        
        public FamilyTreeNode build() {
            return new FamilyTreeNode(this);
        }
    }

    public static class Child {
        private String left;
        private String top;
        private String id;
        private String fullname;
        private String mlineDisplay;
        private String mlineTop;
        private String mlineLeft;
        private String mlineWidth;
        private String l1PlineDisplay;
        private String l2PlineDisplay;
        private String l3PlineDisplay;
        private String l1PlineLeft;
        private String l2PlineTop;
        private String l2PlineLeft;
        private String l3PlineTop;
        private String l3PlineLeft;

        public Child left(String val) {
            left = val;
            return this;
        }

        public Child top(String val) {
            top = val;
            return this;
        }

        public Child id(String val) {
            id = val;
            return this;
        }

        public Child fullname(String val) {
            fullname = val;
            return this;
        }

        public Child mLineDisplay(String val) {
            mlineDisplay = val;
            return this;
        }

        public Child mLineTop(String val) {
            mlineTop = val;
            return this;
        }

        public Child mLineLeft(String val) {
            mlineLeft = val;
            return this;
        }

        public Child mLineWidth(String val) {
            mlineWidth = val;
            return this;
        }

        public Child l1PlineDisplay(String val) {
            l1PlineDisplay = val;
            return this;
        }

        public Child l2PlineDisplay(String val) {
            l2PlineDisplay = val;
            return this;
        }

        public Child l3PlineDisplay(String val) {
            l3PlineDisplay = val;
            return this;
        }

        public Child l1PlineLeft(String val) {
            l1PlineLeft = val;
            return this;
        }

        public Child l2PlineLeft(String val) {
            l2PlineLeft = val;
            return this;
        }

        public Child l3PlineLeft(String val) {
            l3PlineLeft = val;
            return this;
        }

        public Child l2PlineTop(String val) {
            l2PlineTop = val;
            return this;
        }

        public Child l3PlineTop(String val) {
            l3PlineTop = val;
            return this;
        }

        public FamilyTreeNode build() {
            return new FamilyTreeNode(this);
        }
    }


}
