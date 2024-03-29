package ix.ibm.waddemo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import ix.ibm.waddemo.pojo.Course;
import ix.ibm.waddemo.pojo.CreateCourseInput;
import ix.ibm.waddemo.service.CourseService;

public class Mutation implements GraphQLMutationResolver {

    private final CourseService courseService;

    public Mutation(CourseService courseService) {
        this.courseService = courseService;
    }

    public Course createCourse(CreateCourseInput input) {
        Course course = new Course();
        course.setTitle(input.getTitle());
        course.setDescription(input.getDescription());

        return courseService.create(course);
    }

    public Course updateCourse(CreateCourseInput input) {
        Course course = new Course();
        course.setTitle(input.getTitle());
        course.setDescription(input.getDescription());

        return courseService.update(course, input.getId());
    }

    public Boolean deleteCourse(Long id) {
        return courseService.delete(id);
    }
}
