package com.ethertons.common;

import com.ethertons.common.FamilyTreeNode.Builder;

public class FamilyTreeNode {

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((fullname == null) ? 0 : fullname.hashCode());
        result = prime * result + ((height == null) ? 0 : height.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((l1PlineDisplay == null) ? 0 : l1PlineDisplay.hashCode());
        result = prime * result
                + ((l1PlineLeft == null) ? 0 : l1PlineLeft.hashCode());
        result = prime * result
                + ((l1PlineTop == null) ? 0 : l1PlineTop.hashCode());
        result = prime * result
                + ((l1PlineWidth == null) ? 0 : l1PlineWidth.hashCode());
        result = prime * result
                + ((l2PlineDisplay == null) ? 0 : l2PlineDisplay.hashCode());
        result = prime * result
                + ((l2PlineLeft == null) ? 0 : l2PlineLeft.hashCode());
        result = prime * result
                + ((l2PlineTop == null) ? 0 : l2PlineTop.hashCode());
        result = prime * result
                + ((l2PlineWidth == null) ? 0 : l2PlineWidth.hashCode());
        result = prime * result
                + ((l3PlineDisplay == null) ? 0 : l3PlineDisplay.hashCode());
        result = prime * result
                + ((l3PlineLeft == null) ? 0 : l3PlineLeft.hashCode());
        result = prime * result
                + ((l3PlineTop == null) ? 0 : l3PlineTop.hashCode());
        result = prime * result
                + ((l3PlineWidth == null) ? 0 : l3PlineWidth.hashCode());
        result = prime * result + ((left == null) ? 0 : left.hashCode());
        result = prime * result
                + ((mlineDisplay == null) ? 0 : mlineDisplay.hashCode());
        result = prime * result
                + ((mlineLeft == null) ? 0 : mlineLeft.hashCode());
        result = prime * result
                + ((mlineTop == null) ? 0 : mlineTop.hashCode());
        result = prime * result
                + ((mlineWidth == null) ? 0 : mlineWidth.hashCode());
        result = prime * result + ((top == null) ? 0 : top.hashCode());
        result = prime * result + ((width == null) ? 0 : width.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FamilyTreeNode other = (FamilyTreeNode) obj;
        if (fullname == null) {
            if (other.fullname != null)
                return false;
        } else if (!fullname.equals(other.fullname))
            return false;
        if (height == null) {
            if (other.height != null)
                return false;
        } else if (!height.equals(other.height))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (l1PlineDisplay == null) {
            if (other.l1PlineDisplay != null)
                return false;
        } else if (!l1PlineDisplay.equals(other.l1PlineDisplay))
            return false;
        if (l1PlineLeft == null) {
            if (other.l1PlineLeft != null)
                return false;
        } else if (!l1PlineLeft.equals(other.l1PlineLeft))
            return false;
        if (l1PlineTop == null) {
            if (other.l1PlineTop != null)
                return false;
        } else if (!l1PlineTop.equals(other.l1PlineTop))
            return false;
        if (l1PlineWidth == null) {
            if (other.l1PlineWidth != null)
                return false;
        } else if (!l1PlineWidth.equals(other.l1PlineWidth))
            return false;
        if (l2PlineDisplay == null) {
            if (other.l2PlineDisplay != null)
                return false;
        } else if (!l2PlineDisplay.equals(other.l2PlineDisplay))
            return false;
        if (l2PlineLeft == null) {
            if (other.l2PlineLeft != null)
                return false;
        } else if (!l2PlineLeft.equals(other.l2PlineLeft))
            return false;
        if (l2PlineTop == null) {
            if (other.l2PlineTop != null)
                return false;
        } else if (!l2PlineTop.equals(other.l2PlineTop))
            return false;
        if (l2PlineWidth == null) {
            if (other.l2PlineWidth != null)
                return false;
        } else if (!l2PlineWidth.equals(other.l2PlineWidth))
            return false;
        if (l3PlineDisplay == null) {
            if (other.l3PlineDisplay != null)
                return false;
        } else if (!l3PlineDisplay.equals(other.l3PlineDisplay))
            return false;
        if (l3PlineLeft == null) {
            if (other.l3PlineLeft != null)
                return false;
        } else if (!l3PlineLeft.equals(other.l3PlineLeft))
            return false;
        if (l3PlineTop == null) {
            if (other.l3PlineTop != null)
                return false;
        } else if (!l3PlineTop.equals(other.l3PlineTop))
            return false;
        if (l3PlineWidth == null) {
            if (other.l3PlineWidth != null)
                return false;
        } else if (!l3PlineWidth.equals(other.l3PlineWidth))
            return false;
        if (left == null) {
            if (other.left != null)
                return false;
        } else if (!left.equals(other.left))
            return false;
        if (mlineDisplay == null) {
            if (other.mlineDisplay != null)
                return false;
        } else if (!mlineDisplay.equals(other.mlineDisplay))
            return false;
        if (mlineLeft == null) {
            if (other.mlineLeft != null)
                return false;
        } else if (!mlineLeft.equals(other.mlineLeft))
            return false;
        if (mlineTop == null) {
            if (other.mlineTop != null)
                return false;
        } else if (!mlineTop.equals(other.mlineTop))
            return false;
        if (mlineWidth == null) {
            if (other.mlineWidth != null)
                return false;
        } else if (!mlineWidth.equals(other.mlineWidth))
            return false;
        if (top == null) {
            if (other.top != null)
                return false;
        } else if (!top.equals(other.top))
            return false;
        if (width == null) {
            if (other.width != null)
                return false;
        } else if (!width.equals(other.width))
            return false;
        return true;
    }

    private String left;
    private String top;
    private String id;
    public String getPaddingTop() {
        return paddingTop;
    }

    public void setPaddingTop(String paddingTop) {
        this.paddingTop = paddingTop;
    }

    public String getPaddingBottom() {
        return paddingBottom;
    }

    public void setPaddingBottom(String paddingBottom) {
        this.paddingBottom = paddingBottom;
    }

    public String getPaddingLeft() {
        return paddingLeft;
    }

    public void setPaddingLeft(String paddingLeft) {
        this.paddingLeft = paddingLeft;
    }

    public String getPaddingRight() {
        return paddingRight;
    }

    public void setPaddingRight(String paddingRight) {
        this.paddingRight = paddingRight;
    }

    private String paddingTop;
    private String paddingBottom;
    private String paddingLeft;
    private String paddingRight;

    private String fullname;
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String birthDate;
    private String location;
    private String mlineDisplay;
    private String mlineTop;
    private String mlineLeft;
    private String mlineWidth;
    private String l1PlineTop;
    private String l1PlineLeft;
    private String l1PlineWidth;
    private String l1PlineDisplay;
    private String l2PlineTop;
    private String l2PlineLeft;
    private String l2PlineWidth;
    private String l2PlineDisplay;
    private String l3PlineTop;
    private String l3PlineLeft;
    private String l3PlineWidth;
    private String l3PlineDisplay;
    private String height;
    private String width;

    public static class Builder {

//        public static final String NODE_WIDTH = "10";
//        public static final String NODE_HEIGHT = "4";
//        public static final String NODE_PADDING_TOP = "2";
//        public static final String NODE_PADDING_BOTTOM = "2";
//        public static final String NODE_PADDING_LEFT = "2";
//        public static final String NODE_PADDING_RIGHT = "2";

        public static final String NODE_WIDTH = "20";
        public static final String NODE_HEIGHT = "8";
        public static final String NODE_PADDING_TOP = "2";
        public static final String NODE_PADDING_BOTTOM = "2";
        public static final String NODE_PADDING_LEFT = "2";
        public static final String NODE_PADDING_RIGHT = "2";
//        
        
        private String left;
        private String top;
        private String id;
        private String fullname;
        private String birthDate;
        private String location;       
        private String mlineDisplay;
        private String mlineTop;
        private String mlineLeft;
        private String mlineWidth;
        private String l1PlineTop;
        private String l1PlineLeft;
        private String l1PlineWidth;
        private String l1PlineDisplay;
        private String l2PlineTop;
        private String l2PlineLeft;
        private String l2PlineWidth;
        private String l2PlineDisplay;
        private String l3PlineTop;
        private String l3PlineLeft;
        private String l3PlineWidth;
        private String l3PlineDisplay;
        private String height;
        private String width;

        public Builder() {
            this.height = NODE_HEIGHT;
            this.width = NODE_WIDTH;
        }

        public Builder left(String val) {
            left = val;
            return this;
        }

        public Builder top(String val) {
            top = val;
            return this;
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder fullname(String val) {
            fullname = val;
            return this;
        }

        public Builder birthDate(String val) {
            birthDate = val;
            return this;
        }        

        public Builder location(String val) {
            location = val;
            return this;
        }         
        
        public Builder mLineDisplay(String val) {
            mlineDisplay = val;
            return this;
        }

        public Builder mLineTop(String val) {
            mlineTop = val;
            return this;
        }

        public Builder mLineLeft(String val) {
            mlineLeft = val;
            return this;
        }

        public Builder mLineWidth(String val) {
            mlineWidth = val;
            return this;
        }

        public Builder l1PlineDisplay(String val) {
            l1PlineDisplay = val;
            return this;
        }

        public Builder l2PlineDisplay(String val) {
            l2PlineDisplay = val;
            return this;
        }

        public Builder l3PlineDisplay(String val) {
            l3PlineDisplay = val;
            return this;
        }

        public Builder l1PlineLeft(String val) {
            l1PlineLeft = val;
            return this;
        }

        public Builder l2PlineLeft(String val) {
            l2PlineLeft = val;
            return this;
        }

        public Builder l3PlineLeft(String val) {
            l3PlineLeft = val;
            return this;
        }

        public Builder l2PlineTop(String val) {
            l2PlineTop = val;
            return this;
        }

        public Builder l3PlineTop(String val) {
            l3PlineTop = val;
            return this;
        }

        public Builder height(String val) {
            height = val;
            return this;
        }
        
        public FamilyTreeNode build() {
            return new FamilyTreeNode(this);
        }

        public Builder width(String val) {
            width = val;
            return this;
        }

    }

    private FamilyTreeNode(Builder builder) {
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
        height = builder.height;
        width = builder.width;
        birthDate = builder.birthDate;
        location = builder.location;
    }

    public String getMlineWidth() {
        return mlineWidth;
    }

    public void setMlineWidth(String mlineWidth) {
        this.mlineWidth = mlineWidth;
    }

    public String getL1PlineTop() {
        return l1PlineTop;
    }

    public void setL1PlineTop(String l1PlineTop) {
        this.l1PlineTop = l1PlineTop;
    }

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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

}
