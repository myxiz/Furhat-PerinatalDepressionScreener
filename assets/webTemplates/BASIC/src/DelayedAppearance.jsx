import * as React from "react"
import PropTypes from "prop-types"
import ReactCSSTransitionGroup from 'react-addons-css-transition-group'; // ES6

export class DelayedAppearance extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            shouldShow: false
        }
        if (!this.state.shouldShow) {
            setTimeout(
                () => this.setState({shouldShow: true}), (props.delaySeconds || 0) * 1000
            )
        }
    }

    render() {
        return this.state.shouldShow
            ?
            <ReactCSSTransitionGroup
                transitionName="fade"
                transitionAppear={true}
                transitionAppearTimeout={500}
                transitionEnterTimeout={500}
                transitionLeave={false}>
                {this.props.children}
            </ReactCSSTransitionGroup>
            : null
    }
}

DelayedAppearance.propTypes = {
    delaySeconds: PropTypes.number
}
