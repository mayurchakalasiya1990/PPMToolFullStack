import React, { Component } from 'react'
import {PropTypes} from 'prop-types'
import {connect} from "react-redux"
import {createProject} from "../../actions/projectAction"
import {classnames} from "classnames"
class AddProject extends Component {

    constructor(){
        super()
        this.state={
            projectName: "",
            projectIdentifier : "",
            description:"",
            startDate:"",
            endDate:"",
            errors:{}

        }
        this.onChange=this.onChange.bind(this)
        this.onSubmit=this.onSubmit.bind(this)
    }

    //life cycle hooks
    componentWillReceiveProps(nextProps){
        if(nextProps.errors){
            this.setState({errors:nextProps.errors})
        }
    }

    onChange(e){
        this.setState({[e.target.name]:e.target.value});
    }

    onSubmit(e){
        e.preventDefault();
        const newProject={
            projectName: this.state.projectName,
            projectIdentifier : this.state.projectIdentifier,
            description:this.state.description,
            startDate:this.state.startDate,
            endDate:this.state.endDate
        }
        console.log(newProject)
        this.props.createProject(newProject,this.props.history)

    }

    render() {
        const {errors} = this.state
        
        return (
            <div>
                
                <div className="project">
                    <div className="container">
                        <div className="row">
                            <div className="col-md-8 m-auto">
                                <h5 className="display-4 text-center">Create Project form</h5>
                                <hr />
                                <form onSubmit={this.onSubmit}>
                                    <div className="form-group mb-3">
                                        <input type="text" className="form-control form-control-lg " placeholder="Project Name" name="projectName" value={this.state.projectName} onChange={this.onChange}/>
                                        <p1>{errors.projectName}</p1>
                                    </div>
                                    <div className="form-group mb-3">
                                        <input type="text" className="form-control form-control-lg" placeholder="Unique Project ID" name="projectIdentifier" value={this.state.projectIdentifier} onChange={this.onChange}/>
                                        <p1>{errors.projectIdentifier}</p1>
                                    </div>
                                    <div className="form-group mb-3">
                                        <textarea className="form-control form-control-lg" placeholder="Project Description" name="description" value={this.state.description} onChange={this.onChange}></textarea>
                                        <p1>{errors.description}</p1>
                                    </div>
                                    <h6>Start Date</h6>
                                    <div className="form-group mb-3">
                                        <input type="date" className="form-control form-control-lg" name="startDate" value={this.state.startDate} onChange={this.onChange}/>
                                        <p1>{errors.startDate}</p1>
                                    </div>
                                    <h6>Estimated End Date</h6>
                                    <div className="form-group mb-3">
                                        <input type="date" className="form-control form-control-lg" name="endDate"  value={this.state.endDate} onChange={this.onChange.bind(this)}/>
                                        <p1>{errors.endDate}</p1>
                                    </div>
                                    <div className="form-group mb-3">
                                        <input type="submit" className="btn btn-primary btn-block mt-4" />
                                    </div>    
                                    
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
AddProject.propTypes = {
    createProject : PropTypes.func.isRequired,
    errors:PropTypes.object.isRequired
}

const mapStateToProps = state => ({
    errors: state.errors
})

export default connect(
    mapStateToProps,
    {createProject}
)(AddProject);